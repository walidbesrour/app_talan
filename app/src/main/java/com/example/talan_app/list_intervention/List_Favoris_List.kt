package com.example.talan_app.list_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_favorisINTER
import com.example.talan_app.databinding.FragmentListFavorisListBinding
import com.example.talan_app.view_model.Favoris_intervention_VM


class List_Favoris_List : Fragment() {

private lateinit var binding : FragmentListFavorisListBinding
private var adapter_List_favorisINTER: Adapter_List_favorisINTER? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            binding = FragmentListFavorisListBinding.inflate(layoutInflater)

        val favoris_intervention_VM : Favoris_intervention_VM = ViewModelProviders.of(this).get(Favoris_intervention_VM::class.java)

        favoris_intervention_VM.getArrayList().observe(this,{ favorisList ->
            adapter_List_favorisINTER = Adapter_List_favorisINTER(requireContext(),favorisList)
            binding.recyclefavorisinter.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclefavorisinter.adapter = adapter_List_favorisINTER
        })





        return binding.root
    }


}