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
import com.example.talan_app.adapters.Adapter_List_MainDoeuvre
import com.example.talan_app.databinding.FragmentMainDoeuvreBinding
import com.example.talan_app.view_model.MainDoeuvreVM

class MainDoeuvreFragment : Fragment() {

    private lateinit var binding: FragmentMainDoeuvreBinding
       private var adapter_List_MainDoeuvre : Adapter_List_MainDoeuvre?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainDoeuvreBinding.inflate(layoutInflater)

        val mainDoeuvreVM : MainDoeuvreVM = ViewModelProvider(this).get(MainDoeuvreVM::class.java)


          mainDoeuvreVM.getArrayList().observe(viewLifecycleOwner, Observer {Doeuvrevm ->

              adapter_List_MainDoeuvre = Adapter_List_MainDoeuvre(requireContext(),Doeuvrevm!! )
            binding.recycleMainOv.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleMainOv.adapter = adapter_List_MainDoeuvre


        })



        return binding.root
    }


}