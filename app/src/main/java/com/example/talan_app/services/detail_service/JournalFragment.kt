package com.example.talan_app.services.detail_service

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_Journal
import com.example.talan_app.databinding.FragmentJournalBinding
import com.example.talan_app.view_model.JournalVM


class JournalFragment : Fragment() {

    private lateinit var binding: FragmentJournalBinding
     private var adapter_List_Journal : Adapter_List_Journal?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentJournalBinding.inflate(layoutInflater)


          val journalVM : JournalVM = ViewModelProvider(this).get(JournalVM::class.java)
        journalVM.getArrayList().observe(viewLifecycleOwner, {jourvm ->


            adapter_List_Journal = Adapter_List_Journal(requireContext(),jourvm!! )
            binding.recycleJournal.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleJournal.adapter = adapter_List_Journal
        })


        return binding.root
    }


}