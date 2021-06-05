package com.example.talan_app.intervention.detail_intervention.detail_plan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_Articles
import com.example.talan_app.databinding.FragmentArticlesBinding
import com.example.talan_app.view_model.ArticlesVM

class ArticlesFragment (won: String?): Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    private var adapter_List_Articles : Adapter_List_Articles?= null
    var wonum = won.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArticlesBinding.inflate(layoutInflater)

           val articlesVM : ArticlesVM = ViewModelProvider(this).get(ArticlesVM::class.java)


          articlesVM.getArrayList().observe(viewLifecycleOwner, Observer {artiVm ->

              adapter_List_Articles = Adapter_List_Articles(requireContext(),artiVm!! )
            binding.recycleArticle.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleArticle.adapter = adapter_List_Articles


        })



        return binding.root
    }

}