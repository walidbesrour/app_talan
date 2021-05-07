package com.example.talan_app.menu_fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.talan_app.adapters.Adapter_List_Actifs
import com.example.talan_app.databinding.FragmentActifFilsBinding

import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.Actif_ListFactory_VM
import com.example.talan_app.view_model.Actif_List_VM
import com.google.zxing.integration.android.IntentIntegrator


class ActifFilsFragment(siteid: String?, assetnum: String?) : Fragment() {

    private lateinit var binding: FragmentActifFilsBinding
    var siteid = siteid.toString()
    var assetnum = assetnum.toString()

    var adapter_list_actifs : Adapter_List_Actifs?=null

    private lateinit var viewModel: Actif_List_VM
    private var resultScan : String = ""
    var isLoading = false
    var pageSize = 50


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentActifFilsBinding.inflate(layoutInflater)



        adapter_list_actifs = Adapter_List_Actifs(requireContext())
        binding.recycleflis.adapter = adapter_list_actifs
        binding.recycleflis.layoutManager = LinearLayoutManager(requireContext())
        val repository = RetrofitRepository()
        val viewModelFactory = Actif_ListFactory_VM(repository)


        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        Log.e("TAG ActifFilsFragment", "  $siteid    $assetnum     $Apikey", )

        viewModel = ViewModelProvider(this, viewModelFactory).get(Actif_List_VM::class.java)
        if (Apikey != null) {
            val Myparent ="parent="+assetnum
            println(Myparent)

            Log.e("TAG ActifFilsFragment", "   $Apikey   $Myparent   $siteid    " )
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn")
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    resultScan = result.contents
                    println("*******************************   $resultScan")
                    Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                println("///////////////////////////////////////////")
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

}