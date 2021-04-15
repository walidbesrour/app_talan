package com.example.talan_app.actifs.detail_actif

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_FilsActifs
import com.example.talan_app.databinding.FragmentFilsDetailBinding
import com.example.talan_app.view_model.FilsActif_List_VM


class FilsDetailFragment : Fragment() {

            private lateinit var binding: FragmentFilsDetailBinding
            private var adapter_List_FilsActifs : Adapter_List_FilsActifs?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
                binding = FragmentFilsDetailBinding.inflate(layoutInflater)

        val filsActifVM : FilsActif_List_VM = ViewModelProvider(this).get(FilsActif_List_VM::class.java)

        filsActifVM.getArrayList().observe(viewLifecycleOwner, Observer {compteur_vms ->

            adapter_List_FilsActifs = Adapter_List_FilsActifs(requireContext(),compteur_vms!! )
            binding.recyclerfils.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerfils.adapter = adapter_List_FilsActifs



        })
        return binding.root
    }


}