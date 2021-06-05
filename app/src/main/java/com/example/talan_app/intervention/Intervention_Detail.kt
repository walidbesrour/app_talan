package com.example.talan_app.intervention

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.R
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.ActivityInterventionDetailBinding
import com.example.talan_app.intervention.detail_intervention.CompteurIntervFragment
import com.example.talan_app.intervention.detail_intervention.PlanFragment
import com.example.talan_app.intervention.detail_intervention.RealisationFragment
import com.example.talan_app.intervention.detail_intervention.RisqPreqIntervFragment
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.Intervention_ListFactory
import com.example.talan_app.view_model.Intervention_List_VM
import com.google.android.material.textfield.TextInputEditText

class Intervention_Detail : AppCompatActivity() {

    private lateinit var binding: ActivityInterventionDetailBinding
    private lateinit var viewModel: Intervention_List_VM
    var txt =""

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
     binding = ActivityInterventionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val won = intent.getStringExtra("wonum")
        val wonum = "wonum=$won"

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = Intervention_ListFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Intervention_List_VM::class.java)


        val sharedPreferences = this.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        if (Apikey != null){
            viewModel.getDetailFavoris(Apikey,wonum,"*")
            viewModel.ResponseInter.observe(this, androidx.lifecycle.Observer { Myresponse1 ->

                if (Myresponse1.isSuccessful) {

                    binding.codeDemande.text = Myresponse1.body()!!.member[0].wonum
                    binding.DiscriptionDesc.text = Myresponse1.body()!!.member[0].description
                    binding.SiteInter.text = Myresponse1.body()!!.member[0].siteid

                    if (Myresponse1.body()!!.member[0].parent != null){
                        binding.parentcode.text = Myresponse1.body()!!.member[0].parent
                    }else{
                        binding.parentcode.visibility = View.GONE
                        binding.ViewParent.visibility = View.GONE
                        binding.codeparent2.visibility = View.GONE
                    }



                    if (Myresponse1.body()!!.member[0].asset != null){
                        binding.codeActifInterv.text = Myresponse1.body()!!.member[0].asset[0].assetnum
                        binding.descActifs.text = Myresponse1.body()!!.member[0].asset[0].description
                    }else{
                        binding.codeActifInterv.visibility = View.GONE
                        binding.descActifs.visibility = View.GONE
                        binding.ViewActif.visibility = View.GONE
                        binding.codeActifInterv1.visibility = View.GONE
                    }

                    if (Myresponse1.body()!!.member[0].worktype != null){
                        binding.typeInterv.text = Myresponse1.body()!!.member[0].worktype
                    }else{
                        binding.typeInterv.text = ""
                    }

                    if (Myresponse1.body()!!.member[0].location != null){
                        binding.emplacementIntv.text = Myresponse1.body()!!.member[0].location
                    }else{
                        binding.emplacementIntv.text = ""
                    }

















                } else {
                    Log.d("response --", Myresponse1.code().toString())
                    Log.d("response --", Myresponse1.message().toString())
                    Log.e("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "onCreate: " )


                }
            })
        }


        setUpTabs()
        binding.btnDescriptionInterv.setOnClickListener {
          descriptioview(txt)
        }

    }

    private fun setUpTabs() {
        val adapter = ViewAdapterPageView(supportFragmentManager)

        adapter.addFragment(PlanFragment(), "PLAN")
        adapter.addFragment(RealisationFragment(), "REALISATION")
        adapter.addFragment(CompteurIntervFragment(), "COMPTEURS")
        adapter.addFragment(RisqPreqIntervFragment(), "RISQUE PRECAUTION")



        binding.viewPageServiceInterv.adapter = adapter
        binding.tabDetailinterv.setupWithViewPager(binding.viewPageServiceInterv)
        binding.tabDetailinterv.getTabAt(0)!!
        binding.tabDetailinterv.getTabAt(1)!!
        binding.tabDetailinterv.getTabAt(2)!!
        binding.tabDetailinterv.getTabAt(3)!!


    }
    fun descriptioview(txt :String){
        val view = View.inflate(this, R.layout.dialog_description_detaille,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        val textView = dialog.findViewById<TextInputEditText>(R.id.DetaiDescription) as TextView
        textView.text= txt
        dialog.findViewById<Button>(R.id.btnok1)?.setOnClickListener { dialog.dismiss() }
    }
}