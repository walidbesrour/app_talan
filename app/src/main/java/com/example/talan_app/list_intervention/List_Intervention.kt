package com.example.talan_app.list_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_intervention
import com.example.talan_app.databinding.FragmentListInterventionBinding
import com.example.talan_app.view_model.Intervention_List_VM


class List_Intervention : Fragment() {

private lateinit var binding : FragmentListInterventionBinding
private var adapterListIntervention : Adapter_List_intervention? =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListInterventionBinding.inflate(layoutInflater)

        val interventionListVm : Intervention_List_VM = ViewModelProviders.of(this).get(Intervention_List_VM ::class.java)

        interventionListVm.getArrayList().observe(this,{ interList ->
            adapterListIntervention = Adapter_List_intervention(requireContext(),interList)
            binding.recycleIntervention.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleIntervention.adapter = adapterListIntervention
        })


        return binding.root
    }


}