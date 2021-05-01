package com.example.talan_app.menu_fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.talan_app.adapters.Adapter_List_Actifs
import com.example.talan_app.databinding.FragmentActifBinding

import com.example.talan_app.view_model.Actif_List_VM
import com.google.zxing.integration.android.IntentIntegrator
import java.util.*

class ActifFragment : Fragment() {

        private lateinit var binding: FragmentActifBinding
        private var adapter_list_actifs: Adapter_List_Actifs?= null
    private var resultScan : String = ""
    var isLoading = false
    var limit = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentActifBinding.inflate(layoutInflater)

        val actif_List_vm : Actif_List_VM =  ViewModelProvider(this).get(Actif_List_VM::class.java)

        actif_List_vm.getArrayList().observe(viewLifecycleOwner, Observer { actif_List_vms ->

            adapter_list_actifs = Adapter_List_Actifs(requireContext(), actif_List_vms!!)
            binding.recycleActif.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleActif.adapter = adapter_list_actifs

            binding.recycleActif.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?

                    if (!isLoading) {
                        if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (actif_List_vms.size - 1)) {
                            isLoading = true
                            binding.progressBar.visibility = View.VISIBLE
                            Handler(Looper.getMainLooper()).postDelayed({
                                println("****************nnnnnnnnnnnnnnnnnnnnnnn*****************************")
                                adapter_list_actifs?.addActif(actif_List_vm.newdata())
                                recyclerView.post { adapter_list_actifs?.notifyDataSetChanged() }

                                binding.progressBar.visibility = View.GONE
                                isLoading = false

                            }, 2000)



                        }
                    }
                    super.onScrolled(recyclerView, dx, dy)
                }
            })


        })

        binding.camera.setOnClickListener {

//            activity?.let{
//                val intent = Intent (it, CameraActivity::class.java)
//                intent.putExtra("samplename", "abd")
//                it.startActivity(intent)
//
//            }

//            val scanner = IntentIntegrator(requireActivity())
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
                    println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn")
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    resultScan = result.contents
                    println("*******************************   $resultScan")
                    Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                println("///////////////////////////////////////////")
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    fun getpage(){
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE


    }

}