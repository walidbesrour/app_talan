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
import com.example.talan_app.adapters.Adapter_List_Tache
import com.example.talan_app.databinding.FragmentTachesBinding
import com.example.talan_app.databinding.TacheBinding
import com.example.talan_app.view_model.TacheVM

class TachesFragment : Fragment() {

            private lateinit var binding: FragmentTachesBinding
            private var adapter_List_Tache : Adapter_List_Tache?= null

            override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
                binding = FragmentTachesBinding.inflate(layoutInflater)


        val tacheVM : TacheVM = ViewModelProvider(this).get(TacheVM::class.java)

        tacheVM.getArrayList().observe(viewLifecycleOwner, Observer {tachevm ->

            adapter_List_Tache = Adapter_List_Tache(requireContext(),tachevm!! )
            binding.recycletache.layoutManager = LinearLayoutManager(requireContext())
            binding.recycletache.adapter = adapter_List_Tache



        })




        return binding.root
    }


}