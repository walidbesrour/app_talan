package com.example.talan_app.intervention

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.ActivityInterventionDetailBinding
import com.example.talan_app.intervention.detail_intervention.CompteurIntervFragment
import com.example.talan_app.intervention.detail_intervention.PlanFragment
import com.example.talan_app.intervention.detail_intervention.RealisationFragment
import com.example.talan_app.intervention.detail_intervention.RisqPreqIntervFragment

class Intervention_Detail : AppCompatActivity() {

    private lateinit var binding: ActivityInterventionDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
     binding = ActivityInterventionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabs()

    }

    private fun setUpTabs() {
        val adapter = ViewAdapterPageView(supportFragmentManager)
        adapter.addFragment(CompteurIntervFragment(), "COMPTEURS")
        adapter.addFragment(RisqPreqIntervFragment(), "RISQUE PRECAUTION")
        adapter.addFragment(RealisationFragment(), "REALISATION")
        adapter.addFragment(PlanFragment(), "PLAN")

        binding.viewPageServiceInterv.adapter = adapter
        binding.tabDetailinterv.setupWithViewPager(binding.viewPageServiceInterv)
        binding.tabDetailinterv.getTabAt(0)!!
        binding.tabDetailinterv.getTabAt(1)!!
        binding.tabDetailinterv.getTabAt(2)!!
        binding.tabDetailinterv.getTabAt(3)!!


    }
}