package com.example.talan_app.menu_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.FragmentInterventionBinding
import com.example.talan_app.list_intervention.List_Favoris_List
import com.example.talan_app.list_intervention.List_Intervention


class InterventionFragment : Fragment() {

    private lateinit var binding: FragmentInterventionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInterventionBinding.inflate(layoutInflater)

        setUpTabs()


        return binding.root
    }

    private fun setUpTabs() {
        val adapter = ViewAdapterPageView(childFragmentManager)
        adapter.addFragment(List_Intervention(), "INTERVENTION")
        adapter.addFragment(List_Favoris_List(), "FAVORIS")

        binding.viewPage.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPage)
        binding.tabs.getTabAt(0)!!
        binding.tabs.getTabAt(1)!!


    }
}