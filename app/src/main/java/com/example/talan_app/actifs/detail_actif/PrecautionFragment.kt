package com.example.talan_app.actifs.detail_actif

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_Precaution

import com.example.talan_app.databinding.FragmentPrecautionBinding
import com.example.talan_app.view_model.PrecautionVM


class PrecautionFragment : Fragment() {


        private lateinit var binding: FragmentPrecautionBinding
        private var adapter_List_Precaution : Adapter_List_Precaution?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPrecautionBinding.inflate(layoutInflater)

        val precautionVM : PrecautionVM = ViewModelProvider(this).get(PrecautionVM::class.java)

        precautionVM.getArrayList().observe(viewLifecycleOwner, Observer {compteur_vms ->

            adapter_List_Precaution = Adapter_List_Precaution(requireContext(),compteur_vms!! )
            binding.recyclerprecaution.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerprecaution.adapter = adapter_List_Precaution



        })



        return binding.root
    }


}