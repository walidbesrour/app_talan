package com.example.talan_app.menu_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_Actifs
import com.example.talan_app.databinding.FragmentActifBinding
import com.example.talan_app.view_model.Actif_List_VM

class ActifFragment : Fragment() {

        private lateinit var binding: FragmentActifBinding
        private var adapter_list_actifs: Adapter_List_Actifs?= null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentActifBinding.inflate(layoutInflater)

        val actif_List_vm : Actif_List_VM =  ViewModelProvider(this).get(Actif_List_VM::class.java)

        actif_List_vm.getArrayList().observe(viewLifecycleOwner, Observer {actif_List_vms ->

            adapter_list_actifs = Adapter_List_Actifs(requireContext(),actif_List_vms!! )
            binding.recycleActif.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleActif.adapter = adapter_list_actifs



        })



        return binding.root
    }

}