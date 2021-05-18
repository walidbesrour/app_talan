package com.example.talan_app.intervention.detail_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapteur_List_Compteur
import com.example.talan_app.databinding.FragmentCompteurIntervBinding
import com.example.talan_app.view_model.Compteur_List_VM


class CompteurIntervFragment : Fragment() {

    private lateinit var binding: FragmentCompteurIntervBinding
//    private  var adapteurlistCompteur : Adapteur_List_Compteur?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            binding = FragmentCompteurIntervBinding.inflate(layoutInflater)
//
//        val compteur_List_vm : Compteur_List_VM =  ViewModelProvider(this).get(Compteur_List_VM::class.java)
//
//
//        compteur_List_vm.getArrayListInterv().observe(viewLifecycleOwner, Observer {compteur_vms ->
//
//            adapteurlistCompteur = Adapteur_List_Compteur(requireContext(),compteur_vms!! )
//            binding.recyclecompteur1.layoutManager = LinearLayoutManager(requireContext())
//            binding.recyclecompteur1.adapter = adapteurlistCompteur
//
//
//
//        })
        return binding.root
    }


}