package com.example.talan_app.intervention.detail_intervention.detail_plan

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_InterventionsFilles
import com.example.talan_app.adapters.Adapter_List_Precaution
import com.example.talan_app.adapters.Adapter_List_favorisINTER
import com.example.talan_app.databinding.FragmentInterventionsFillsBinding
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.Intervention_ListFactory
import com.example.talan_app.view_model.Intervention_List_VM
import com.example.talan_app.view_model.InterventionsAssocieesVM
import com.example.talan_app.view_model.PrecautionVM


class InterventionsFillesFragment(won: String?) : Fragment() {

    private lateinit var binding: FragmentInterventionsFillsBinding
    var wonum = won.toString()
    private var adapter_List_InterventionsFilles : Adapter_List_InterventionsFilles?= null
    private lateinit var viewModel: Intervention_List_VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInterventionsFillsBinding.inflate(layoutInflater)

        adapter_List_InterventionsFilles = Adapter_List_InterventionsFilles(requireContext())
        binding.recyclefilles.adapter = adapter_List_InterventionsFilles
        binding.recyclefilles.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = Intervention_ListFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(Intervention_List_VM::class.java)


        println("zzzzzzzzzzzzzzzzzzzzzzzz $wonum")
        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
        if (Apikey != null) {
            viewModel.getFilsFavoris(Apikey,"wonum,description,status","PARENT=$wonum and wogroup!=$wonum")
            viewModel.ResponseFILS.observe(viewLifecycleOwner,{ Myresponse ->
                if (Myresponse.isSuccessful) {
                    Myresponse.body()?.let { adapter_List_InterventionsFilles!!.setData(it.member) }
                }else{
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    Log.d("list fils interventiion ", "error")
                }
            })
        }

        return binding.root
    }

}