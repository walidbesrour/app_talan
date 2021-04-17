package com.example.talan_app.intervention.detail_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_Risque
import com.example.talan_app.databinding.FragmentRisqueIntervBinding
import com.example.talan_app.view_model.RisqueVM

class RisqueIntervFragment : Fragment() {

        private lateinit var binding : FragmentRisqueIntervBinding
        private var adapter_List_Risque : Adapter_List_Risque?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRisqueIntervBinding.inflate(layoutInflater)



        val risqueVM : RisqueVM = ViewModelProvider(this).get(RisqueVM::class.java)


        risqueVM.getArrayListInterv().observe(viewLifecycleOwner, Observer {compteur_vms ->

            adapter_List_Risque = Adapter_List_Risque(requireContext(),compteur_vms!! )
            binding.recyclerisque1.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerisque1.adapter = adapter_List_Risque



        })



        return binding.root
    }


}