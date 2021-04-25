package com.example.talan_app.services.detail_service

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_Journal
import com.example.talan_app.databinding.FragmentJournalBinding
import com.example.talan_app.view_model.JournalVM
import com.google.android.material.datepicker.MaterialDatePicker


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

        binding.addjournal.setOnClickListener {
            viewOk()
        }

        return binding.root
    }
    fun viewOk(){
        val view = View.inflate(requireActivity(), R.layout.dialog_journal,null)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)

        dialog.findViewById<Button>(R.id.btnok1)?.setOnClickListener { dialog.dismiss() }

        var txt : EditText =  dialog.findViewById<EditText>(R.id.DateJoural) as EditText

        dialog.findViewById<EditText>(R.id.DateJoural)?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("Date", start.toString())
                println("*********** $count")
                if (count == 0){
                    val builder : MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
                    builder.setTitleText("selectionner la Date")
                    val picker : MaterialDatePicker<*> = builder.build()
                    picker.show(childFragmentManager , picker.toString())
                    picker.addOnPositiveButtonClickListener {
                        txt.setText(picker.headerText)

                    }
                }

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

    }

}