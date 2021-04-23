package com.example.talan_app.list_intervention

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
import com.example.talan_app.adapters.Adapter_List_intervention
import com.example.talan_app.databinding.FragmentListInterventionBinding
import com.example.talan_app.intervention.AddIntervention
import com.example.talan_app.view_model.Intervention_List_VM
import com.google.zxing.integration.android.IntentIntegrator


class List_Intervention : Fragment() {

private lateinit var binding : FragmentListInterventionBinding
private var adapterListIntervention : Adapter_List_intervention? =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListInterventionBinding.inflate(layoutInflater)

        val interventionListVm : Intervention_List_VM = ViewModelProvider(this).get(Intervention_List_VM ::class.java)

        interventionListVm.getArrayList().observe(viewLifecycleOwner,{ interList ->
            adapterListIntervention = Adapter_List_intervention(requireContext(),interList)
            binding.recycleIntervention.layoutManager = LinearLayoutManager(requireContext())
            binding.recycleIntervention.adapter = adapterListIntervention
        })

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