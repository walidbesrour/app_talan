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
import com.example.talan_app.adapters.Adapter_List_Precaution
import com.example.talan_app.databinding.FragmentPrecautionBinding
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.PrecautionFactoryVM
import com.example.talan_app.view_model.PrecautionVM
import java.lang.Exception


class PrecautionFragment(num: String?) : Fragment() {

        private lateinit var binding: FragmentPrecautionBinding

        var siteid = num.toString()
        private var adapter_List_Precaution : Adapter_List_Precaution?= null
        private lateinit var VIEWMODEL : PrecautionVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPrecautionBinding.inflate(layoutInflater)
        adapter_List_Precaution = Adapter_List_Precaution(requireContext())
        binding.recyclerprecaution.adapter = adapter_List_Precaution
        binding.recyclerprecaution.layoutManager = LinearLayoutManager(requireContext())
        val repository = RetrofitRepository()
        val viewModelFactory = PrecautionFactoryVM(repository)
        VIEWMODEL = ViewModelProvider(this,viewModelFactory).get(PrecautionVM::class.java)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        if(Apikey != null){
            VIEWMODEL.getPrecautionActif(Apikey,"ASSETNUM=$siteid","safetylexicon")

            VIEWMODEL.myResponse.observe(viewLifecycleOwner,{ MyResponse ->
                if (MyResponse.isSuccessful){
                    try {
                        println("************  les risque *********************")
                        println(MyResponse.body())

                        val zz : Int = MyResponse.body()!!.member[0].safetylexicon.size -1
                        MyResponse.body()?.let { adapter_List_Precaution!!.setData(it.member[0].safetylexicon[zz].hazardprec) }
                        println("$zz")
                        for (i in 0 until zz){
                            println("**************************************")
                            println("$i")
                            MyResponse.body()?.let { adapter_List_Precaution!!.addActif(it.member[0].safetylexicon[i].hazardprec) }
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