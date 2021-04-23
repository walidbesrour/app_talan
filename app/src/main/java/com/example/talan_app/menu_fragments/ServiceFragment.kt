package com.example.talan_app.menu_fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.adapters.Adapter_List_Service
import com.example.talan_app.databinding.FragmentServiceBinding
import com.example.talan_app.services.AddService
import com.example.talan_app.view_model.Service_List_VM
import com.google.zxing.integration.android.IntentIntegrator


class ServiceFragment : Fragment()  {

    private lateinit var binding: FragmentServiceBinding
    private var adapter_List_Service: Adapter_List_Service?= null

    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentServiceBinding.inflate(layoutInflater)

        val service_list_VM : Service_List_VM = ViewModelProvider(this).get(Service_List_VM::class.java)

        binding.addService.setOnClickListener {

             val i = Intent(requireContext() , AddService::class.java)
            startActivity(i)

        }

        service_list_VM.getArrayList().observe(viewLifecycleOwner,{serv_list_vm ->
            adapter_List_Service = Adapter_List_Service(requireContext(),serv_list_vm)
            binding.recycleService.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleService.adapter = adapter_List_Service

        })

        binding.cameraService.setOnClickListener {
            val scanner = IntentIntegrator.forSupportFragment(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }


        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

}