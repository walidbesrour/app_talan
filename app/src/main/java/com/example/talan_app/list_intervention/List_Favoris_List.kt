package com.example.talan_app.list_intervention

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.talan_app.adapters.Adapter_List_favorisINTER
import com.example.talan_app.adapters.Adapter_List_intervention
import com.example.talan_app.databinding.FragmentListFavorisListBinding
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.Intervention_ListFactory
import com.example.talan_app.view_model.Intervention_List_VM


class List_Favoris_List : Fragment() {

    private lateinit var binding : FragmentListFavorisListBinding
    private var adapter_List_favorisINTER: Adapter_List_favorisINTER? = null
    private lateinit var viewModel: Intervention_List_VM


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            binding = FragmentListFavorisListBinding.inflate(layoutInflater)



        adapter_List_favorisINTER = Adapter_List_favorisINTER(requireContext())
        binding.recyclefavorisinter.adapter = adapter_List_favorisINTER
        binding.recyclefavorisinter.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = Intervention_ListFactory(repository)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        viewModel = ViewModelProvider(this, viewModelFactory).get(Intervention_List_VM::class.java)


        if (Apikey != null) {
            viewModel.getListInterventionFavoris(Apikey,"*","bookmark{userid=\"B.WALID\"and app=\"WOTRACK\"}")
            viewModel.ResponseFavoris.observe(viewLifecycleOwner,{ Myresponse ->
                if (Myresponse.isSuccessful) {
                    Myresponse.body()?.let { adapter_List_favorisINTER!!.setData(it.member) }
                }else{
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    Log.d("list des favoris ", "error")
                }
            })
        }

        return binding.root
    }


}