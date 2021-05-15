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

import com.example.talan_app.adapters.Adapter_List_Actifs
import com.example.talan_app.databinding.FragmentActifBinding
import com.example.talan_app.model.Apikey
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.Actif_ListFactory_VM

import com.example.talan_app.view_model.Actif_List_VM
import com.google.zxing.integration.android.IntentIntegrator
import java.util.*

class ActifFragment : Fragment() {


        private lateinit var binding: FragmentActifBinding
//        private val adapter_list_actifs   by lazy {Adapter_List_Actifs(this)}
 var adapter_list_actifs :Adapter_List_Actifs ?=null

    private lateinit var viewModel: Actif_List_VM
    private var resultScan : String = ""
    var isLoading = false
    var pageSize = 50
    var pageno = 1

    private val REQ_CODE_SPEECH_INPUT = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentActifBinding.inflate(layoutInflater)

        adapter_list_actifs = Adapter_List_Actifs(requireContext())
        binding.recycleActif.adapter = adapter_list_actifs
        binding.recycleActif.layoutManager = LinearLayoutManager(requireContext())
        val repository = RetrofitRepository()
        val viewModelFactory = Actif_ListFactory_VM(repository)


        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)


        viewModel = ViewModelProvider(this, viewModelFactory).get(Actif_List_VM::class.java)
        if (Apikey != null) {
            viewModel.getListActifs(Apikey,"*",pageSize,pageno)



        viewModel.myResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse ->
            if (Myresponse.isSuccessful) {
                println("****** test  Actif **** ${Myresponse.body()} ")
                println("oooooooooooooooooooooooooooooooooooooooooooooooooo")
                Myresponse.body()?.let { adapter_list_actifs!!.setData(it.member) }

                binding.recycleActif.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)

                        val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                        if (!isLoading) {
                            val sizeList : Int? = Myresponse.body()?.let { adapter_list_actifs!!.list_actif.size }

                            if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (sizeList!! - 1)) {

                                isLoading = true
                                binding.progressBar.visibility = View.VISIBLE
                                Handler(Looper.getMainLooper()).postDelayed({
                                    var  newpageno  = pageno++
                                    viewModel.getListActifs(Apikey,"*",pageSize,newpageno)
                                    viewModel.myResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse1 ->
                                        if (Myresponse1.isSuccessful) {
                                            Myresponse.body()?.let { adapter_list_actifs!!.addActif(it.member) }
                                            recyclerView.post { adapter_list_actifs?.notifyDataSetChanged() }
                                        } else {
                                            Log.d("response --", Myresponse.code().toString())
                                            Log.d("response --", Myresponse.message().toString())
                                            Log.d("ajouter des nouveau element ", "error")
                                        }


                                    })







                                    binding.progressBar.visibility = View.GONE
                                    isLoading = false
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



        binding.camera.setOnClickListener {

            val scanner = IntentIntegrator.forSupportFragment(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()

        }
        binding.voiceflis.setOnClickListener {   speechInput()  }


        return binding.root
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




}