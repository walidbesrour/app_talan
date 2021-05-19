package com.example.talan_app.actifs.detail_actif

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_Actifs
import com.example.talan_app.databinding.FragmentFilsDetailBinding
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.Actif_ListFactory_VM
import com.example.talan_app.view_model.Actif_List_VM


class FilsDetailFragment(num: String?, siteid: String?) : Fragment() {

            private lateinit var binding: FragmentFilsDetailBinding
    var siteid = siteid.toString()
    var assetnum = num.toString()

    var adapter_list_actifs : Adapter_List_Actifs?=null
    private lateinit var viewModel: Actif_List_VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
                binding = FragmentFilsDetailBinding.inflate(layoutInflater)

        adapter_list_actifs = Adapter_List_Actifs(requireContext())
        binding.recyclerfils.adapter = adapter_list_actifs
        binding.recyclerfils.layoutManager = LinearLayoutManager(requireContext())
        val repository = RetrofitRepository()
        val viewModelFactory = Actif_ListFactory_VM(repository)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Actif_List_VM::class.java)

        if (Apikey != null) {
            val Myparent ="parent="+assetnum

            Log.e("children Actif in detail Actif ", "   $Apikey   $Myparent   $siteid    " )
            viewModel.getListActifFils(Apikey,"*",Myparent,siteid)

            viewModel.myResponsefils.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse1 ->
                if (Myresponse1.isSuccessful) {
                    println("****** test  list fils **** ${Myresponse1.body()} ")
                    Myresponse1.body()?.let { adapter_list_actifs!!.setData(it.member) }




                } else {
                    Log.d("response --", Myresponse1.code().toString())
                    Log.d("response --", Myresponse1.message().toString())
                    println("+++++++++++++++++++++++++++++++++++++")
                }
            })


        }

        return binding.root
    }


}