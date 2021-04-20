package com.example.talan_app.intervention.detail_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.FragmentPlanBinding
import com.example.talan_app.intervention.detail_intervention.detail_plan.*


class PlanFragment : Fragment() {

        private lateinit var binding :FragmentPlanBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPlanBinding.inflate(layoutInflater)

        setUpTabs()


        return binding.root
    }

    private fun setUpTabs() {
        val adapter = ViewAdapterPageView(childFragmentManager)
        adapter.addFragment(InterventionsFillesFragment(), "FILLS")
        adapter.addFragment(TachesFragment(), "TACHES")
        adapter.addFragment(MainDoeuvreFragment(), "MAIN D'OEUVRE")
        adapter.addFragment(ArticlesFragment(), "ARTICLES")
        adapter.addFragment(OutilsFragment(), "OUTILS")
        adapter.addFragment(ServicesPlanFragment(), "SERVICES")


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