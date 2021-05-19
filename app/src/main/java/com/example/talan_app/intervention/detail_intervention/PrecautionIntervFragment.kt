package com.example.talan_app.intervention.detail_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talan_app.R
import com.example.talan_app.adapters.Adapter_List_Precaution
import com.example.talan_app.databinding.FragmentPrecautionIntervBinding
import com.example.talan_app.view_model.PrecautionVM

class PrecautionIntervFragment : Fragment() {


    private lateinit var binding:FragmentPrecautionIntervBinding
    private var adapter_List_Precaution : Adapter_List_Precaution?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentPrecautionIntervBinding.inflate(layoutInflater)




        return binding.root
    }


}