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
import com.example.talan_app.adapters.Adapteur_List_PieceDetachee
import com.example.talan_app.databinding.FragmentPieceDetacheeBinding
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.PieceDetacheeFactory
import com.example.talan_app.view_model.PieceDetacheeVM
import java.lang.Exception


class PieceDetacheeFragment(num: String?) : Fragment() {

    private lateinit var binding : FragmentPieceDetacheeBinding
    var siteid = num.toString()

    private  var adapteurPieceDetachee : Adapteur_List_PieceDetachee?= null
    private lateinit var VIEWMODEL : PieceDetacheeVM


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPieceDetacheeBinding.inflate(layoutInflater)

        adapteurPieceDetachee = Adapteur_List_PieceDetachee(requireContext())
        binding.recyclePiece.adapter = adapteurPieceDetachee
        binding.recyclePiece.layoutManager = LinearLayoutManager(requireContext())
        val repository = RetrofitRepository()
        val viewModelFactory = PieceDetacheeFactory(repository)
        VIEWMODEL = ViewModelProvider(this,viewModelFactory).get(PieceDetacheeVM::class.java)
        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
        if(Apikey != null){
            VIEWMODEL.getPieceDetachee(Apikey,"ASSETNUM=$siteid","sparepart")
            VIEWMODEL.myResponse.observe(viewLifecycleOwner,{ MyResponse ->
                if (MyResponse.isSuccessful){
                    try {
                        MyResponse.body()?.let { adapteurPieceDetachee!!.setData(it.member[0].sparepart) }
                    }catch(e: Exception){
                        Log.e("eureur", "onCreateView: ", )
                    }
                }else{
                    Log.d("une erreur dans le piece detachée des actif", MyResponse.code().toString())
                    Log.d("response  piece detachée --", MyResponse.message().toString())
                }

            })
        }


            return binding.root
    }


}