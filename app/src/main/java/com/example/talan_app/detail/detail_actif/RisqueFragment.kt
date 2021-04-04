package com.example.talan_app.detail.detail_actif

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_Risque
import com.example.talan_app.databinding.FragmentRisqueBinding
import com.example.talan_app.view_model.RisqueVM

class RisqueFragment : Fragment() {

    private lateinit var binding : FragmentRisqueBinding
    private var adapter_List_Risque : Adapter_List_Risque?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRisqueBinding.inflate(layoutInflater)

        val risqueVM : RisqueVM = ViewModelProvider(this).get(RisqueVM::class.java)


        risqueVM.getArrayList().observe(viewLifecycleOwner, Observer {compteur_vms ->

            adapter_List_Risque = Adapter_List_Risque(requireContext(),compteur_vms!! )
            binding.recyclerisque.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerisque.adapter = adapter_List_Risque



        })


        return binding.root
    }


}