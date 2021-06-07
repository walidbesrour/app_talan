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
import com.example.talan_app.adapters.Adapter_List_Precation_Inter
import com.example.talan_app.adapters.Adapter_List_RisqueInter
import com.example.talan_app.databinding.FragmentPrecautionIntervBinding
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.Intervention_ListFactory
import com.example.talan_app.view_model.Intervention_List_VM

class PrecautionIntervFragment(SelectWonum: String?)  : Fragment() {


    private lateinit var binding:FragmentPrecautionIntervBinding
    private var adapter_List_Precation_Inter : Adapter_List_Precation_Inter?= null
    private lateinit var viewModel: Intervention_List_VM

    var wonum = SelectWonum.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentPrecautionIntervBinding.inflate(layoutInflater)

        adapter_List_Precation_Inter = Adapter_List_Precation_Inter(requireContext())
        binding.recyclerprecautionInterv.adapter = adapter_List_Precation_Inter
        binding.recyclerprecautionInterv.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = Intervention_ListFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(Intervention_List_VM::class.java)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        if (Apikey != null) {
            println("***************** $wonum")
            viewModel.getPrecautionInter(Apikey,"$wonum","WOHAZARDPREC")
            viewModel.ResponsePrecaution.observe(viewLifecycleOwner,{ Myresponse ->
                if (Myresponse.isSuccessful) {


                    if (Myresponse.body()!!.member[0].wohazardprec == null){

                    }else{
                        Myresponse.body()?.let { adapter_List_Precation_Inter!!.setData(it.member[0].wohazardprec) }
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