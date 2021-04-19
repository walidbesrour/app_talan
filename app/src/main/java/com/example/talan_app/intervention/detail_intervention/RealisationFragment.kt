package com.example.talan_app.intervention.detail_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_Realisation
import com.example.talan_app.databinding.FragmentRealisationBinding
import com.example.talan_app.view_model.RealisationVM


class RealisationFragment : Fragment() {

        private lateinit var binding: FragmentRealisationBinding
        private  var adapter_List_Realisation : Adapter_List_Realisation?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            binding = FragmentRealisationBinding.inflate(layoutInflater)

//

            val realisationVM : RealisationVM =  ViewModelProvider(this).get(RealisationVM::class.java)


        realisationVM.getArrayList().observe(viewLifecycleOwner, Observer {compteur_vms ->

            adapter_List_Realisation = Adapter_List_Realisation(requireContext(),compteur_vms!! )
            binding.recyclerolation.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerolation.adapter = adapter_List_Realisation



        })


        return binding.root
    }


}