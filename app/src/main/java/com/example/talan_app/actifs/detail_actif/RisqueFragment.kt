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

import com.example.talan_app.adapters.Adapter_List_Risque
import com.example.talan_app.databinding.FragmentRisqueBinding
import com.example.talan_app.model.MyRisque
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.PieceDetacheeVM
import com.example.talan_app.view_model.RisqueFactoryVM
import com.example.talan_app.view_model.RisqueVM
import java.lang.Exception


class RisqueFragment(num: String?) : Fragment() {

    private lateinit var binding : FragmentRisqueBinding

    var siteid = num.toString()
    private var adapter_List_Risque : Adapter_List_Risque?= null
    private lateinit var VIEWMODEL : RisqueVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRisqueBinding.inflate(layoutInflater)

        adapter_List_Risque = Adapter_List_Risque(requireContext())
        binding.recyclerisque.adapter = adapter_List_Risque
        binding.recyclerisque.layoutManager = LinearLayoutManager(requireContext())
        val repository = RetrofitRepository()
        val viewModelFactory = RisqueFactoryVM(repository)

        VIEWMODEL = ViewModelProvider(this,viewModelFactory).get(RisqueVM::class.java)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        if(Apikey != null){
            VIEWMODEL.getRisqueActif(Apikey,"ASSETNUM=$siteid","safetylexicon")
            VIEWMODEL.myResponse.observe(viewLifecycleOwner,{ MyResponse ->
                if (MyResponse.isSuccessful){
                    try {
                        println("************  les risque *********************")
                        println(MyResponse.body())

                        var zz : Int = MyResponse.body()!!.member[0].safetylexicon.size -1
                        MyResponse.body()?.let { adapter_List_Risque!!.setData(it.member[0].safetylexicon[zz].hazard) }
                        println("$zz")
                        for (i in 0 until zz){
                            println("**************************************")
                            println("$i")
                            MyResponse.body()?.let { adapter_List_Risque!!.addActif(it.member[0].safetylexicon[i].hazard) }
//                            recyclerView.post { adapter_List_Risque?.notifyDataSetChanged() }
                        }




                    }catch(e: Exception){
                        Log.e("eureur", "onCreateView:Risque ", )
                    }
                }else{
                    Log.d("une erreur dans List des risque", MyResponse.code().toString())
                    Log.d("response  List des risque --", MyResponse.message().toString())
                }

            })
        }

        return binding.root
    }


}

