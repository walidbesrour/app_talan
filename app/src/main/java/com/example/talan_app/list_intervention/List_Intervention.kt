package com.example.talan_app.list_intervention

import android.app.Activity
import android.content.Context
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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.adapters.Adapter_List_intervention
import com.example.talan_app.databinding.FragmentListInterventionBinding
import com.example.talan_app.intervention.AddIntervention
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import com.example.talan_app.repository.RetrofitRepositoryService
import com.example.talan_app.view_model.Intervention_ListFactory
import com.example.talan_app.view_model.Intervention_List_VM
import com.example.talan_app.view_model.Service_ListFactory_VM
import com.example.talan_app.view_model.Service_List_VM
import com.google.zxing.integration.android.IntentIntegrator
import kotlin.math.log


class List_Intervention : Fragment() {

private lateinit var binding : FragmentListInterventionBinding
private var adapterListIntervention : Adapter_List_intervention? =null
    private lateinit var viewModel: Intervention_List_VM

    var LoadingSer = false
    var pageSizes = 150
    var pageno = 1

    var newpage = 2




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListInterventionBinding.inflate(layoutInflater)



        adapterListIntervention = Adapter_List_intervention(requireContext())
        binding.recycleIntervention.adapter = adapterListIntervention
        binding.recycleIntervention.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryIntervention()
        val viewModelFactory = Intervention_ListFactory(repository)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        viewModel = ViewModelProvider(this, viewModelFactory).get(Intervention_List_VM::class.java)

        if (Apikey != null) {
            viewModel.getListIntervention(Apikey,"*",pageSizes,pageno)
            viewModel.myResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse ->
                if (Myresponse.isSuccessful) {

                    println("111111111111111111111111111111111111")

                    Myresponse.body()?.let { adapterListIntervention!!.setData(it.member) }

                    binding.recycleIntervention.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)

                            val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?




                            if (!LoadingSer) {

                                val sizeList : Int? = Myresponse.body()?.let { adapterListIntervention!!.list_intervention.size }
                                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (sizeList!! - 1)) {


                                    LoadingSer = true
                                    binding.progressBar.visibility = View.VISIBLE
                                    Handler(Looper.getMainLooper()).postDelayed({

                                        viewModel.getListIntervention1(Apikey,"*",pageSizes,newpage)
                                        viewModel.myResponse1.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse1 ->
                                            if (Myresponse1.isSuccessful) {

                                                newpage++
                                                LoadingSer = false

                                                Myresponse1.body()?.let { adapterListIntervention!!.addActif(it.member) }
                                                recyclerView.post { adapterListIntervention?.notifyDataSetChanged() }
                                            } else {
                                                Log.d("response --", Myresponse.code().toString())
                                                Log.d("response --", Myresponse.message().toString())
                                                Log.d("intervention list ", "error")
                                            }


                                        })

                                        binding.progressBar.visibility = View.GONE

                                    }, 1000)




                                }

                            }



                        }
                    })


                } else {
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    println("+++++++++++++++++++++++++++++++++++++")
                }
            })
        }












        binding.newintervention.setOnClickListener {
            var intent = Intent(requireContext(),AddIntervention::class.java)
            startActivity(intent)
        }

        binding.cameraintervention.setOnClickListener {
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