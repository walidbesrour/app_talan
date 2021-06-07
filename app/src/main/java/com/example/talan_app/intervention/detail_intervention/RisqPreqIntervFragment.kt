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


class RisqPreqIntervFragment(SelectWonum: String?): Fragment() {

    private lateinit var binding : FragmentRisqPreqIntervBinding
    var wonum = SelectWonum.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRisqPreqIntervBinding.inflate(layoutInflater)
        setUpTabs(wonum)
        return binding.root
    }

    private fun setUpTabs(wonum :String) {
        val adapter = ViewAdapterPageView(childFragmentManager)
        adapter.addFragment(RisqueIntervFragment(wonum), "RISQUES")
        adapter.addFragment(PrecautionIntervFragment(wonum), "PRECAUTION")

        binding.viewPageActInt.adapter = adapter
        binding.tabsActInt.setupWithViewPager(binding.viewPageActInt)
        binding.tabsActInt.getTabAt(0)!!
        binding.tabsActInt.getTabAt(1)!!
    }
}