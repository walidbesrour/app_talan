package com.example.talan_app.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.ActivityActifDetailBinding
import com.example.talan_app.detail.detail_actif.CompteurFragment
import com.example.talan_app.detail.detail_actif.FilsDetailFragment
import com.example.talan_app.detail.detail_actif.RisquePrecautionFragment


class Actif_Detail : AppCompatActivity() {


    private lateinit var binding: ActivityActifDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityActifDetailBinding.inflate(layoutInflater)
      setContentView(binding.root)
        setUpTabs()
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
}