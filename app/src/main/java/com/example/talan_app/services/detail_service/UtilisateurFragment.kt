package com.example.talan_app.services.detail_service

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.databinding.FragmentUtilisateurBinding
import com.example.talan_app.repository.RetrofitRepositoryService
import com.example.talan_app.view_model.Service_ListFactory_VM
import com.example.talan_app.view_model.Service_List_VM


class UtilisateurFragment (num: String?) : Fragment() {

    private lateinit var binding: FragmentUtilisateurBinding

    private lateinit var viewModel: Service_List_VM
    var ticketid = num.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUtilisateurBinding.inflate(layoutInflater)

        val repository = RetrofitRepositoryService()
        val viewModelFactory = Service_ListFactory_VM(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Service_List_VM::class.java)

        val sharedAPI = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedAPI.getString("SAVE_APIKEY", null)

        if (Apikey != null){
            viewModel.getServiceAffecter(Apikey,ticketid,"affectedperson,affectedphone,affectedemail,reportedemail,reportedby,reportedphone")

            viewModel.myResponseAffecter.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse ->

                if (Myresponse.isSuccessful) {


                    binding.nomConsigne.setText(Myresponse.body()!!.member[0].reportedby)
                    binding.telephoneConsigne.setText(Myresponse.body()!!.member[0].reportedphone)
                    binding.emailConsigne.setText(Myresponse.body()!!.member[0].reportedemail)
                    binding.nomAffectee.setText(Myresponse.body()!!.member[0].affectedperson)
                    binding.telephoneAffectee.setText(Myresponse.body()!!.member[0].affectedphone)
                    binding.emailAffectee.setText(Myresponse.body()!!.member[0].affectedemail)




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