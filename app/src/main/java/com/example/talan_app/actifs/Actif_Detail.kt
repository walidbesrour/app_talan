package com.example.talan_app.actifs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.talan_app.R
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.ActivityActifDetailBinding
import com.example.talan_app.actifs.detail_actif.CompteurFragment
import com.example.talan_app.actifs.detail_actif.FilsDetailFragment
import com.example.talan_app.actifs.detail_actif.RisquePrecautionFragment
import com.google.android.material.textfield.TextInputEditText


class Actif_Detail : AppCompatActivity() {


    private lateinit var binding: ActivityActifDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityActifDetailBinding.inflate(layoutInflater)
      setContentView(binding.root)
        setUpTabs()
        binding.btnDescription.setOnClickListener {
            var txt : String = "Le Bitcoin, depuis quelques années déjà, fait beaucoup parler de lui. "
            descriptioview(txt)
        }
    }
    private fun setUpTabs() {
        val adapter = ViewAdapterPageView(supportFragmentManager)
        adapter.addFragment(CompteurFragment(), "COMPTEURS")
        adapter.addFragment(RisquePrecautionFragment(), "RISQUES PRECAUTION")
        adapter.addFragment(FilsDetailFragment(), "ACTIFS FILS ")

        binding.viewPageActif.adapter = adapter
        binding.tabDetailActif.setupWithViewPager(binding.viewPageActif)
        binding.tabDetailActif.getTabAt(0)!!
        binding.tabDetailActif.getTabAt(1)!!


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