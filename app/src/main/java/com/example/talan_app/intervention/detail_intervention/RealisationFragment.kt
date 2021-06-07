package com.example.talan_app.intervention.detail_intervention

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_Realisation
import com.example.talan_app.databinding.FragmentRealisationBinding
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.Intervention_ListFactory
import com.example.talan_app.view_model.Intervention_List_VM


class RealisationFragment (SelectWonum: String?) : Fragment() {

    private lateinit var binding: FragmentRealisationBinding

    private var adapter_List_Realisation : Adapter_List_Realisation?= null
    private lateinit var viewModel: Intervention_List_VM

    var wonum = SelectWonum.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            binding = FragmentRealisationBinding.inflate(layoutInflater)

        adapter_List_Realisation = Adapter_List_Realisation(requireContext())
        binding.RecyleReal.adapter = adapter_List_Realisation
        binding.RecyleReal.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = Intervention_ListFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(Intervention_List_VM::class.java)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        if (Apikey != null) {
            println("***************** $wonum")
            viewModel.getRealisationInter(Apikey,"$wonum","assignment{scheduledate,laborhrs,person{displayname,personid}}")
            viewModel.ResponseRealisation.observe(viewLifecycleOwner,{ Myresponse ->
                if (Myresponse.isSuccessful) {


                    println(Myresponse.body())

                    if (Myresponse.body()!!.member[0].assignment == null){

                    }else{
                        Myresponse.body()?.let { adapter_List_Realisation!!.setData(it.member[0].assignment) }
                    }


                }else{
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    Log.d("list Realisation ", "error")
                }
            })
        }


        return binding.root
    }


}