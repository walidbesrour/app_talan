package com.example.talan_app.services

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
import com.example.talan_app.databinding.ActivityServiceDetailBinding
import com.example.talan_app.repository.RetrofitRepositoryService
import com.example.talan_app.services.detail_service.DateFragment
import com.example.talan_app.services.detail_service.EtatActifFragment
import com.example.talan_app.services.detail_service.JournalFragment
import com.example.talan_app.services.detail_service.UtilisateurFragment
import com.example.talan_app.view_model.Service_ListFactory_VM
import com.example.talan_app.view_model.Service_List_VM
import com.google.android.material.textfield.TextInputEditText

class Service_Detail : AppCompatActivity() {

    private lateinit var binding: ActivityServiceDetailBinding
    private lateinit var viewModel: Service_List_VM
    var descriptionService =""

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        binding = ActivityServiceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val num = intent.getStringExtra("ticketid")
        val ticketid = "ticketid=$num"

        setUpTabs(ticketid.toString())

        val repository = RetrofitRepositoryService()
        val viewModelFactory = Service_ListFactory_VM(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Service_List_VM::class.java)

        val sharedAPI = this.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedAPI.getString("SAVE_APIKEY", null)

        if (Apikey != null){
            viewModel.getDetailService(Apikey,ticketid,"ticketid,description,status,asset,locations,tkserviceaddress,description_longdescription")
            viewModel.myResponseService.observe(this, androidx.lifecycle.Observer { Myresponse1 ->

                if (Myresponse1.isSuccessful) {

                    binding.codeDemande.text = Myresponse1.body()!!.member[0].ticketid
                    binding.DemandeDesc.text = Myresponse1.body()!!.member[0].description
                    binding.actifService.text = Myresponse1.body()!!.member[0].status

                    if(Myresponse1.body()!!.member[0].asset != null){
                        binding.codeActif.text = Myresponse1.body()!!.member[0].asset[0].assetnum
                        binding.descAtif.text = Myresponse1.body()!!.member[0].asset[0].description
                    }else{
                        binding.codeActif.text = ""
                        binding.descAtif.text = ""
                    }

                    if(Myresponse1.body()!!.member[0].locations != null){
                        binding.Emplacement.text = Myresponse1.body()!!.member[0].locations[0].location
                        binding.descEmplacement.text = Myresponse1.body()!!.member[0].locations[0].description
                    }else{
                        binding.Emplacement.text = ""
                        binding.descEmplacement.text = ""
                    }

                    if(Myresponse1.body()!!.member[0].address != null){
                        binding.Address.text = Myresponse1.body()!!.member[0].address[0].addressline3
                        binding.city.text = Myresponse1.body()!!.member[0].address[0].regiondistrict
                        binding.adress.text = Myresponse1.body()!!.member[0].address[0].city
                        binding.Province.text = Myresponse1.body()!!.member[0].address[0].streetaddress
                    }else{
                        binding.Address.text = ""
                        binding.city.text = ""
                        binding.adress.text = ""
                        binding.Province.text = ""
                    }

                    if( Myresponse1.body()!!.member[0].description_longdescription != null){
                        descriptionService = Myresponse1.body()!!.member[0].description_longdescription
                    }


                } else {
                    Log.d("response --", Myresponse1.code().toString())
                    Log.d("response --", Myresponse1.message().toString())
                    Log.e("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "onCreate: " )


                }
            })

        }


        binding.btnDescriptionService.setOnClickListener {

            descriptioview(descriptionService)
        }


    }


    private fun setUpTabs(num :String) {
        val adapter = ViewAdapterPageView(supportFragmentManager)
        adapter.addFragment(DateFragment(num), "Planification")
        adapter.addFragment(UtilisateurFragment(num), "AFFECTATION")
        adapter.addFragment(EtatActifFragment(), "Etat de l'actif")
        adapter.addFragment(JournalFragment(), "Journal des travaux")

        binding.viewPageService.adapter = adapter
        binding.tabDetailService.setupWithViewPager(binding.viewPageService)
        binding.tabDetailService.getTabAt(0)!!
        binding.tabDetailService.getTabAt(1)!!
        binding.tabDetailService.getTabAt(2)!!
        binding.tabDetailService.getTabAt(3)!!


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