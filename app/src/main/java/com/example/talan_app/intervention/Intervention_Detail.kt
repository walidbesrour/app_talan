package com.example.talan_app.intervention

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.talan_app.R
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.ActivityInterventionDetailBinding
import com.example.talan_app.intervention.detail_intervention.CompteurIntervFragment
import com.example.talan_app.intervention.detail_intervention.PlanFragment
import com.example.talan_app.intervention.detail_intervention.RealisationFragment
import com.example.talan_app.intervention.detail_intervention.RisqPreqIntervFragment
import com.google.android.material.textfield.TextInputEditText

class Intervention_Detail : AppCompatActivity() {

    private lateinit var binding: ActivityInterventionDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
     binding = ActivityInterventionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabs()
        binding.btnDescriptionInterv.setOnClickListener {
            var txt : String = "MacBook Pro 16-inch 2021 release date and price. So far Apple hasn't made any official announcements about future MacBooks, but word is ..."
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