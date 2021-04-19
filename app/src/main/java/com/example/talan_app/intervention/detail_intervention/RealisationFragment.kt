package com.example.talan_app.intervention.detail_intervention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talan_app.R
import com.example.talan_app.databinding.FragmentRealisationBinding


class RealisationFragment : Fragment() {

        private lateinit var binding: FragmentRealisationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            binding = FragmentRealisationBinding.inflate(layoutInflater)



        return binding.root
    }


}