package com.example.talan_app.services.detail_service

import android.content.Context
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
import com.example.talan_app.repository.RetrofitRepositoryService
import com.example.talan_app.view_model.JournalFactoryVM
import com.example.talan_app.view_model.JournalVM
import com.example.talan_app.view_model.Service_ListFactory_VM
import com.example.talan_app.view_model.Service_List_VM
import com.google.android.material.datepicker.MaterialDatePicker
import java.lang.Exception


class JournalFragment (num: String?) : Fragment() {

    private lateinit var binding: FragmentJournalBinding
    private lateinit var viewModel: JournalVM
     private var adapter_List_Journal : Adapter_List_Journal?= null
    var ticketid = num.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentJournalBinding.inflate(layoutInflater)


        adapter_List_Journal = Adapter_List_Journal(requireContext())
        binding.recycleJournal.adapter = adapter_List_Journal
        binding.recycleJournal.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryService()
        val viewModelFactory = JournalFactoryVM(repository)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        viewModel = ViewModelProvider(this, viewModelFactory).get(JournalVM::class.java)

        if (Apikey != null) {
            viewModel.getServiceJournal(Apikey,ticketid,"worklog")

            viewModel.myResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse ->

                if (Myresponse.isSuccessful) {

                    println("*************** ${Myresponse.body()} ***************")

                    try {
                        Myresponse.body()?.let { adapter_List_Journal!!.setData(it.member[0].worklog) }
                    }catch(e: Exception){
                        Log.e("eureur ", "onCreateView: ", )
                    }


                } else {
                    Log.d("error journal response --", Myresponse.code().toString())
                    Log.d("error journal response  --", Myresponse.message().toString())



                }
            })

        }

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