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
import com.example.talan_app.adapters.Adapteur_List_Compteur
import com.example.talan_app.databinding.FragmentCompteurBinding
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.CompteurFactory_VM
import com.example.talan_app.view_model.Compteur_List_VM


class CompteurFragment : Fragment() {

    private lateinit var binding: FragmentCompteurBinding
    private  var adapteurlistCompteur : Adapteur_List_Compteur?= null
    private lateinit var VIEWMODEL : Compteur_List_VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = FragmentCompteurBinding.inflate(layoutInflater)

        adapteurlistCompteur = Adapteur_List_Compteur(requireContext())
        binding.recyclecompteur.adapter = adapteurlistCompteur
        binding.recyclecompteur.layoutManager = LinearLayoutManager(requireContext())
        val repository = RetrofitRepository()
        val viewModelFactory = CompteurFactory_VM(repository)
        VIEWMODEL = ViewModelProvider(this,viewModelFactory).get(Compteur_List_VM::class.java)


        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
        if(Apikey != null){
            VIEWMODEL.getCompteurActif(Apikey,"ASSETNUM=13143","assetmeter")
            VIEWMODEL.myResponse.observe(viewLifecycleOwner,{ MyResponse ->
                if (MyResponse.isSuccessful){
                    println("=======================================")
                    println(MyResponse.body())
                    MyResponse.body()?.let { adapteurlistCompteur!!.setData(it.member[0].assetmeter) }
                }else  {
                    Log.d("une erreur dans le compteur des actif", MyResponse.code().toString())
                    Log.d("response --", MyResponse.message().toString())

                }
            })
        }

        return binding.root
    }


}