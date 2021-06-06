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
import com.example.talan_app.adapters.Adapter_List_Articles
import com.example.talan_app.adapters.Adapter_List_MainDoeuvre
import com.example.talan_app.databinding.FragmentArticlesBinding
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.view_model.PlanInterVM
import com.example.talan_app.view_model.PlanInterVMFactory

class ArticlesFragment (won: String?): Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    private var adapter_List_Articles : Adapter_List_Articles?= null
    private lateinit var viewModel: PlanInterVM
    var wonum = won.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArticlesBinding.inflate(layoutInflater)

        adapter_List_Articles = Adapter_List_Articles(requireContext())
        binding.recycleArticle.adapter = adapter_List_Articles
        binding.recycleArticle.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = PlanInterVMFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(PlanInterVM::class.java)
        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)

        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
        if (Apikey != null) {

            viewModel.getArticleInter(Apikey,"wonum=$wonum","WPMATERIAL{itemnum,description,itemqty,unitcost}")
            viewModel.myResponseArticle.observe(viewLifecycleOwner,{ Myresponse ->
                if (Myresponse.isSuccessful) {


                    if (Myresponse.body()!!.member[0].wpmaterial == null){

                    }else{
                        Myresponse.body()?.let { adapter_List_Articles!!.setData(it.member[0].wpmaterial) }
                    }

                }else{
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    Log.d("list article intervention ", "error")
                }
            })
        }

        return binding.root
    }

}