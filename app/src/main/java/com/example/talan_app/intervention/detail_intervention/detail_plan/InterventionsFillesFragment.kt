package com.example.talan_app.intervention.detail_intervention.detail_plan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_InterventionsFilles
import com.example.talan_app.adapters.Adapter_List_Precaution
import com.example.talan_app.databinding.FragmentInterventionsFillsBinding
import com.example.talan_app.view_model.InterventionsAssocieesVM
import com.example.talan_app.view_model.PrecautionVM


class InterventionsFillesFragment : Fragment() {

    private lateinit var binding: FragmentInterventionsFillsBinding
        private var adapter_List_InterventionsFilles : Adapter_List_InterventionsFilles?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInterventionsFillsBinding.inflate(layoutInflater)


        val fillesInterventionVM : InterventionsAssocieesVM = ViewModelProvider(this).get(InterventionsAssocieesVM::class.java)


//        fillesInterventionVM.getArrayList().observe(viewLifecycleOwner, Observer {fillesvm ->
//
//            adapter_List_InterventionsFilles = Adapter_List_InterventionsFilles(requireContext(),fillesvm!! )
//            binding.recyclefilles.layoutManager = LinearLayoutManager(requireContext())
//            binding.recyclefilles.adapter = adapter_List_InterventionsFilles
//
//
//
//        })

        return binding.root
    }

}