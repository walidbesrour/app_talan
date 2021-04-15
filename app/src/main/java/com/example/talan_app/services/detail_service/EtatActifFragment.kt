package com.example.talan_app.services.detail_service

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_InterventionsAssociees
import com.example.talan_app.adapters.Adapteur_List_Compteur
import com.example.talan_app.databinding.FragmentEtatActifBinding
import com.example.talan_app.view_model.InterventionsAssocieesVM


class EtatActifFragment : Fragment() {

    private lateinit var binding: FragmentEtatActifBinding
    private var adapter_List_InterventionsAssociees : Adapter_List_InterventionsAssociees?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEtatActifBinding.inflate(layoutInflater)

        val interventionsAssocieesVM : InterventionsAssocieesVM = ViewModelProvider(this).get(InterventionsAssocieesVM::class.java)
        interventionsAssocieesVM.getArrayList().observe(viewLifecycleOwner, {AssocieesVM ->


            adapter_List_InterventionsAssociees = Adapter_List_InterventionsAssociees(requireContext(),AssocieesVM!! )
            binding.recycle.layoutManager = LinearLayoutManager(requireContext())
            binding.recycle.adapter = adapter_List_InterventionsAssociees
        })


        return binding.root
    }


}