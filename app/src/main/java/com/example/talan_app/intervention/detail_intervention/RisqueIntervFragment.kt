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
import com.example.talan_app.adapters.Adapter_List_RisqueInter
import com.example.talan_app.databinding.FragmentRisqueIntervBinding
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.Intervention_ListFactory
import com.example.talan_app.view_model.Intervention_List_VM


class RisqueIntervFragment (SelectWonum: String?): Fragment() {

    private lateinit var binding : FragmentRisqueIntervBinding
    private var adapter_List_RisqueInter : Adapter_List_RisqueInter?= null
    private lateinit var viewModel: Intervention_List_VM

        var wonum = SelectWonum.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRisqueIntervBinding.inflate(layoutInflater)

        adapter_List_RisqueInter = Adapter_List_RisqueInter(requireContext())
        binding.recyclerisque1.adapter = adapter_List_RisqueInter
        binding.recyclerisque1.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = Intervention_ListFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(Intervention_List_VM::class.java)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        if (Apikey != null) {
            println("***************** $wonum")
            viewModel.getRisqueInter(Apikey,"$wonum","WOSAFETYLINK")
            viewModel.ResponseRisque.observe(viewLifecycleOwner,{ Myresponse ->
                if (Myresponse.isSuccessful) {


                    if (Myresponse.body()!!.member[0].wosafetylink == null){

                    }else{
                        Myresponse.body()?.let { adapter_List_RisqueInter!!.setData(it.member[0].wosafetylink) }
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