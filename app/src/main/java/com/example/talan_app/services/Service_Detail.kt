package com.example.talan_app.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.ActivityServiceDetailBinding
import com.example.talan_app.services.detail_service.DateFragment
import com.example.talan_app.services.detail_service.EtatActifFragment
import com.example.talan_app.services.detail_service.JournalFragment
import com.example.talan_app.services.detail_service.UtilisateurFragment

class Service_Detail : AppCompatActivity() {

    private lateinit var binding: ActivityServiceDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        binding = ActivityServiceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabs()


    }


    private fun setUpTabs() {
        val adapter = ViewAdapterPageView(supportFragmentManager)
        adapter.addFragment(DateFragment(), "Date")
        adapter.addFragment(UtilisateurFragment(), "Utilisateur")
        adapter.addFragment(EtatActifFragment(), "Etat de l'actif")
        adapter.addFragment(JournalFragment(), "Journal des travaux")

        binding.viewPageService.adapter = adapter
        binding.tabDetailService.setupWithViewPager(binding.viewPageService)
        binding.tabDetailService.getTabAt(0)!!
        binding.tabDetailService.getTabAt(1)!!
        binding.tabDetailService.getTabAt(2)!!
        binding.tabDetailService.getTabAt(3)!!


    }
}