package com.example.talan_app.intervention.detail_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.FragmentPlanBinding
import com.example.talan_app.intervention.detail_intervention.detail_plan.*


class PlanFragment(won: String?) : Fragment() {

        private lateinit var binding :FragmentPlanBinding
        var wonum = won.toString()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPlanBinding.inflate(layoutInflater)

        setUpTabs(wonum)


        return binding.root
    }

    private fun setUpTabs(wonum :String) {
        val adapter = ViewAdapterPageView(childFragmentManager)
        adapter.addFragment(InterventionsFillesFragment(wonum), "FILLS")
        adapter.addFragment(TachesFragment(wonum), "TACHES")
        adapter.addFragment(MainDoeuvreFragment(wonum), "MAIN D'OEUVRE")
        adapter.addFragment(ArticlesFragment(wonum), "ARTICLES")
        adapter.addFragment(ServicesPlanFragment(wonum), "SERVICES")
        adapter.addFragment(OutilsFragment(wonum), "OUTILS")



        binding.viewplan.adapter = adapter
        binding.tabplan.setupWithViewPager(binding.viewplan)
        binding.tabplan.getTabAt(0)!!
        binding.tabplan.getTabAt(1)!!
        binding.tabplan.getTabAt(2)!!
        binding.tabplan.getTabAt(3)!!
        binding.tabplan.getTabAt(4)!!
        binding.tabplan.getTabAt(5)!!


    }
}