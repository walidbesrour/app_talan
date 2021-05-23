package com.example.talan_app.services.detail_service

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.databinding.FragmentDateBinding
import com.example.talan_app.repository.RetrofitRepositoryService
import com.example.talan_app.view_model.Service_ListFactory_VM
import com.example.talan_app.view_model.Service_List_VM

class DateFragment (num: String?) : Fragment() {

    private lateinit var binding: FragmentDateBinding
    private lateinit var viewModel: Service_List_VM
    var ticketid = num.toString()

            override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDateBinding.inflate(layoutInflater)

                val repository = RetrofitRepositoryService()
                val viewModelFactory = Service_ListFactory_VM(repository)
                viewModel = ViewModelProvider(this, viewModelFactory).get(Service_List_VM::class.java)

                val sharedAPI = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
                val Apikey = sharedAPI.getString("SAVE_APIKEY", null)

                if (Apikey != null){
                    viewModel.getServicePlanification(Apikey,ticketid,"reportdate,affecteddate,actualfinish")

                    viewModel.myResponsePlanification.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse ->

                        if (Myresponse.isSuccessful) {


                            binding.rapport.setText(Myresponse.body()!!.member[0].reportdate)
                            binding.affectation.setText(Myresponse.body()!!.member[0].affecteddate)
                            binding.objectif.setText(Myresponse.body()!!.member[0].actualfinish)




                        } else {
                            Log.d("response --", Myresponse.code().toString())
                            Log.d("response --", Myresponse.message().toString())
                            Log.e("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "onCreate: " )


                        }
                    })
                }



       return binding.root
    }


}