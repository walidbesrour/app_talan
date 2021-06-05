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
import com.example.talan_app.adapters.Adapter_List_Outil
import com.example.talan_app.databinding.FragmentOutilsBinding
import com.example.talan_app.view_model.OutilVM


class OutilsFragment(won: String?) : Fragment() {

    private lateinit var binding: FragmentOutilsBinding
     private var adapter_List_Outil : Adapter_List_Outil?= null
    var wonum = won.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOutilsBinding.inflate(layoutInflater)



      val outilVM : OutilVM = ViewModelProvider(this).get(OutilVM::class.java)


          outilVM.getArrayList().observe(viewLifecycleOwner, Observer {outilvm ->

              adapter_List_Outil = Adapter_List_Outil(requireContext(),outilvm!! )
            binding.recycleOutil.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleOutil.adapter = adapter_List_Outil


        })


        return binding.root
    }


}