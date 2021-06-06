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
import com.example.talan_app.adapters.Adapter_List_MainDoeuvre
import com.example.talan_app.adapters.Adapter_List_PlanServices
import com.example.talan_app.databinding.FragmentServicesPlanBinding
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.PlanInterVM
import com.example.talan_app.view_model.PlanInterVMFactory

class ServicesPlanFragment  (won: String?): Fragment() {

    private lateinit var binding: FragmentServicesPlanBinding
    private var adapter_List_PlanServices : Adapter_List_PlanServices?= null
    private lateinit var viewModel: PlanInterVM


        var wonum = won.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentServicesPlanBinding.inflate(layoutInflater)

        adapter_List_PlanServices = Adapter_List_PlanServices(requireContext())
        binding.recycleserv.adapter = adapter_List_PlanServices
        binding.recycleserv.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = PlanInterVMFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(PlanInterVM::class.java)
        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)

        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
        if (Apikey != null) {

            viewModel.getServInter(Apikey,"wonum=$wonum","WPSERVICE{itemnum,description,unitcost,itemqty}")
            viewModel.myResponseServ.observe(viewLifecycleOwner,{ Myresponse ->
                if (Myresponse.isSuccessful) {
                    if (Myresponse.body()!!.member[0].wpservice == null){

                    }else{

                            Myresponse.body()?.let { adapter_List_PlanServices!!.setData(it.member[0].wpservice) }


                    }

                }else{
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    Log.d("list main d oeuvre ", "error")
                }
            })
        }

        return binding.root
    }


}