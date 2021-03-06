package com.example.talan_app.services.detail_service

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_InterventionsAssociees
import com.example.talan_app.adapters.Adapteur_List_Compteur
import com.example.talan_app.databinding.FragmentEtatActifBinding
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.repository.RetrofitRepositoryService
import com.example.talan_app.view_model.*
import java.lang.Exception


class EtatActifFragment (num: String? , asset : String?) : Fragment() {

    private lateinit var binding: FragmentEtatActifBinding
    private lateinit var viewModel: Service_List_VM
    private lateinit var viewModel1: InterventionsAssocieesVM
    var ticketid = num.toString()
    var assetNum = asset.toString()



    private var adapter_List_InterventionsAssociees : Adapter_List_InterventionsAssociees?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEtatActifBinding.inflate(layoutInflater)

        val repository = RetrofitRepositoryService()
        val viewModelFactory = Service_ListFactory_VM(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Service_List_VM::class.java)

        val sharedAPI = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedAPI.getString("SAVE_APIKEY", null)

        if (Apikey != null){
            viewModel.getServiceActif(Apikey,ticketid,"asset,locations")

            viewModel.myResponseActif.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse ->

                if (Myresponse.isSuccessful) {

                    println("******************************")
                    println(Myresponse.body())


                 try {

                     if (Myresponse.body()!!.member[0].asset[0] != null){

                         binding.NActif.text = Myresponse.body()!!.member[0].asset[0].assetnum
                         binding.descriptionDetail.text = Myresponse.body()!!.member[0].asset[0].description
                         binding.txtStatus.text = Myresponse.body()!!.member[0].asset[0].status
                         binding.EtatActif.text = Myresponse.body()!!.member[0].asset[0].siteid
                     }


                     if (Myresponse.body()!!.member[0].locations[0] != null){


                         binding.Emplacement.text = Myresponse.body()!!.member[0].locations[0].location
                         binding.descEmplacement.text = Myresponse.body()!!.member[0].locations[0].description
                     }


                     if (Myresponse.body()!!.member[0].parent != null){

                         binding.codeparent.text = Myresponse.body()!!.member[0].parent
                     }


                 }catch (e:Exception){
                     println(e)
                 }

                } else {
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    Log.e("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "onCreate: " )


                }
            })
        }
        Log.e("test assetid", "====: $assetNum", )


        adapter_List_InterventionsAssociees = Adapter_List_InterventionsAssociees(requireContext())
        binding.recycle.adapter = adapter_List_InterventionsAssociees
        binding.recycle.layoutManager = LinearLayoutManager(requireContext())

        val repository1 = RetrofitRepository()
        val viewModelFactory1 = InterventionsAssocieesFactoryVM(repository1)

        viewModel1 = ViewModelProvider(this,viewModelFactory1).get(InterventionsAssocieesVM::class.java)

        if(Apikey != null){
            viewModel1.getDetailInterv(Apikey,assetNum,"workorder")
            viewModel1.myResponseDetailInterv.observe(viewLifecycleOwner,{ MyResponse ->
                if (MyResponse.isSuccessful){
                    println("===========***** detail intervention *****================")
                    println(MyResponse.body())
                    try {
                        MyResponse.body()?.let { adapter_List_InterventionsAssociees!!.setData(it.member[0].workorder) }
                    }catch(e:Exception){
                        Log.e("eureur Intervention assosier", "onCreateView: ", )
                    }

                }else  {
                    Log.d("une erreur dans le compteur des actif", MyResponse.code().toString())
                    Log.d("response --", MyResponse.message().toString())

                }
            })
          }




        return binding.root
    }


}