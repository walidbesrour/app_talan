package com.example.talan_app.intervention.detail_intervention.detail_plan

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_InterventionsFilles
import com.example.talan_app.adapters.Adapter_List_Tache
import com.example.talan_app.databinding.FragmentTachesBinding
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.Intervention_ListFactory
import com.example.talan_app.view_model.Intervention_List_VM
import com.example.talan_app.view_model.PlanInterVM
import com.example.talan_app.view_model.PlanInterVMFactory

class TachesFragment (won: String?): Fragment() {

            private lateinit var binding: FragmentTachesBinding
            private var adapter_List_Tache : Adapter_List_Tache?= null
            private lateinit var viewModel: PlanInterVM


           var wonum = won.toString()
            override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
                binding = FragmentTachesBinding.inflate(layoutInflater)

                adapter_List_Tache = Adapter_List_Tache(requireContext())
                binding.recycletache.adapter = adapter_List_Tache
                binding.recycletache.layoutManager = LinearLayoutManager(requireContext())


                val repository = RetrofitRepositoryIntervention()
                val viewModelFactory = PlanInterVMFactory(repository)

                viewModel = ViewModelProvider(this, viewModelFactory).get(PlanInterVM::class.java)
                val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)

                val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
                if (Apikey != null) {

                    viewModel.getTacheInter(Apikey,"wonum=$wonum","woactivity{wosequence,description,estdur}")
                    viewModel.myResponseTache.observe(viewLifecycleOwner,{ Myresponse ->
                        if (Myresponse.isSuccessful) {
                            Myresponse.body()?.let { adapter_List_Tache!!.setData(it.member[0].woactivity) }
                        }else{
                            Log.d("response --", Myresponse.code().toString())
                            Log.d("response --", Myresponse.message().toString())
                            Log.d("list tache intervention ", "error")
                        }
                    })
                }

        return binding.root
    }


}