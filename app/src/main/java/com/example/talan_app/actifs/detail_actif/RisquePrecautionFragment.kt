package com.example.talan_app.actifs.detail_actif

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.FragmentRisquePrecautionBinding


class RisquePrecautionFragment(num: String?) : Fragment() {

    private lateinit var binding: FragmentRisquePrecautionBinding
    var siteid = num.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRisquePrecautionBinding.inflate(layoutInflater)

        setUpTabs(siteid)
        return binding.root
    }

    private fun setUpTabs(num :String) {
        val adapter = ViewAdapterPageView(childFragmentManager)
        adapter.addFragment(RisqueFragment(num), "RISQUES")
        adapter.addFragment(PrecautionFragment(num), "PRECAUTION")

        binding.viewPageAct.adapter = adapter
        binding.tabsAct.setupWithViewPager(binding.viewPageAct)
        binding.tabsAct.getTabAt(0)!!
        binding.tabsAct.getTabAt(1)!!
    }
}