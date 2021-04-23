package com.example.talan_app.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.talan_app.R
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.ActivityServiceDetailBinding
import com.example.talan_app.services.detail_service.DateFragment
import com.example.talan_app.services.detail_service.EtatActifFragment
import com.example.talan_app.services.detail_service.JournalFragment
import com.example.talan_app.services.detail_service.UtilisateurFragment
import com.google.android.material.textfield.TextInputEditText

class Service_Detail : AppCompatActivity() {

    private lateinit var binding: ActivityServiceDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        binding = ActivityServiceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabs()
        binding.btnDescriptionService.setOnClickListener {
            var txt : String = "Apple wasn’t even expected to HAVE an event this Spring, but they surprised us by not only doing "
            descriptioview(txt)
        }


    }


    private fun setUpTabs() {
        val adapter = ViewAdapterPageView(supportFragmentManager)
        adapter.addFragment(DateFragment(), "Libellé")
        adapter.addFragment(UtilisateurFragment(), "AFFECTATION")
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