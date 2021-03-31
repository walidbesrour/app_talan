package com.example.talan_app.menu_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_Service
import com.example.talan_app.databinding.FragmentServiceBinding
import com.example.talan_app.view_model.Service_List_VM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class ServiceFragment : Fragment() {

    private lateinit var binding: FragmentServiceBinding
    private var adapter_List_Service: Adapter_List_Service?= null

    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentServiceBinding.inflate(layoutInflater)

        val service_list_VM : Service_List_VM = ViewModelProvider(this).get(Service_List_VM::class.java)

        service_list_VM.getArrayList().observe(viewLifecycleOwner,{serv_list_vm ->
            adapter_List_Service = Adapter_List_Service(requireContext(),serv_list_vm)
            binding.recycleService.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleService.adapter = adapter_List_Service

        })


        return binding.root
    }

}