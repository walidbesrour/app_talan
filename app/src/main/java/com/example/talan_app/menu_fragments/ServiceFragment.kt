package com.example.talan_app.menu_fragments

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.RecognizerIntent
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_Service
import com.example.talan_app.databinding.FragmentServiceBinding
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.repository.RetrofitRepositoryService
import com.example.talan_app.services.AddService
import com.example.talan_app.view_model.Service_ListFactory_VM

import com.example.talan_app.view_model.Service_List_VM
import com.google.zxing.integration.android.IntentIntegrator
import java.util.*


class ServiceFragment : Fragment()  {

    private lateinit var binding: FragmentServiceBinding
    private var adapter_List_Service: Adapter_List_Service?= null
    private lateinit var viewModel: Service_List_VM

    private val REQ_CODE_SPEECH_INPUT = 100

    var LoadingSer = false
    var pageSizes = 150
    var pageno = 1
    var newpageno =2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentServiceBinding.inflate(layoutInflater)

        adapter_List_Service = Adapter_List_Service(requireContext())
        binding.recycleservice.adapter = adapter_List_Service
        binding.recycleservice.layoutManager = LinearLayoutManager(requireContext())

        val repository = RetrofitRepositoryService()
        val viewModelFactory = Service_ListFactory_VM(repository)


        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
         viewModel = ViewModelProvider(this, viewModelFactory).get(Service_List_VM::class.java)

        if (Apikey != null) {
            viewModel.getListService(Apikey,"*",pageSizes,pageno)
            viewModel.myResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse ->
                if (Myresponse.isSuccessful) {


                    Myresponse.body()?.let { adapter_List_Service!!.setData(it.member) }

                    binding.recycleservice.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)

                            val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                            if (!LoadingSer) {

                                val sizeList : Int? = Myresponse.body()?.let { adapter_List_Service!!.list_service.size }

                                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (sizeList!! - 1)) {

                                    LoadingSer = true
                                    binding.progressBar.visibility = View.VISIBLE
                                    Handler(Looper.getMainLooper()).postDelayed({
                                          newpageno
                                        viewModel.getListService1(Apikey,"*",pageSizes,newpageno)
                                        viewModel.myResponse1.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse1 ->
                                            if (Myresponse1.isSuccessful) {
                                                newpageno++
                                                Myresponse1.body()?.let { adapter_List_Service!!.addActif(it.member) }
                                                recyclerView.post { adapter_List_Service?.notifyDataSetChanged() }
                                            } else {
                                                Log.d("response --", Myresponse.code().toString())
                                                Log.d("response --", Myresponse.message().toString())
                                                Log.d("ajouter des nouveau element  Sevice", "error")
                                            }


                                        })







                                        binding.progressBar.visibility = View.GONE
                                        LoadingSer = false
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








        binding.addService.setOnClickListener {

             val i = Intent(requireContext() , AddService::class.java)
            startActivity(i)

        }



        binding.cameraService.setOnClickListener {
            val scanner = IntentIntegrator.forSupportFragment(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }

        binding.voice.setOnClickListener {
            speechInput()
        }


        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            REQ_CODE_SPEECH_INPUT -> if (resultCode == Activity.RESULT_OK && null != data) {
                val result: ArrayList<String> = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
                 binding.numPort1.setText(result.get(0))
            }

        }

        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
//                    Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                    binding.numPort1.setText( result.contents)
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    fun speechInput() {

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_alert))


        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT)
        } catch (a: ActivityNotFoundException) {
            Toast.makeText(requireContext(), getString(R.string.not_supported), Toast.LENGTH_SHORT).show()
        }

    }

}