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
import com.example.talan_app.adapters.Adapter_List_PlanServices
import com.example.talan_app.databinding.FragmentServicesPlanBinding
import com.example.talan_app.view_model.ServicePlanVM

class ServicesPlanFragment  (won: String?): Fragment() {

        private lateinit var binding: FragmentServicesPlanBinding
        private var adapter_List_PlanServices : Adapter_List_PlanServices?= null
        var wonum = won.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentServicesPlanBinding.inflate(layoutInflater)

      val servicePlanVM : ServicePlanVM = ViewModelProvider(this).get(ServicePlanVM::class.java)


          servicePlanVM.getArrayList().observe(viewLifecycleOwner, Observer {Servicevm ->

              adapter_List_PlanServices = Adapter_List_PlanServices(requireContext(),Servicevm!! )
            binding.recycleserv.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleserv.adapter = adapter_List_PlanServices


        })



        return binding.root
    }


}