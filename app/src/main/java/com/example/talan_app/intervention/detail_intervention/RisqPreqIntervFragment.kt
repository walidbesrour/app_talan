package com.example.talan_app.intervention.detail_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talan_app.R
import com.example.talan_app.actifs.detail_actif.PrecautionFragment
import com.example.talan_app.actifs.detail_actif.RisqueFragment
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.FragmentRisqPreqIntervBinding


class RisqPreqIntervFragment : Fragment() {

    private lateinit var binding : FragmentRisqPreqIntervBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRisqPreqIntervBinding.inflate(layoutInflater)

        return binding.root
    }

    private fun setUpTabs() {
        val adapter = ViewAdapterPageView(childFragmentManager)
        adapter.addFragment(RisqueIntervFragment(), "RISQUES")
        adapter.addFragment(PrecautionIntervFragment(), "PRECAUTION")

        binding.viewPageActInt.adapter = adapter
        binding.tabsAct.setupWithViewPager(binding.viewPageActInt)
        binding.tabsAct.getTabAt(0)!!
        binding.tabsAct.getTabAt(1)!!
    }
}