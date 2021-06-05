 package com.example.talan_app.menu_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talan_app.R
import com.example.talan_app.databinding.FragmentHomeBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.ArrayList

 class HomeFragment : Fragment() {

     private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        setBarChart()
        setPieChart()

        return binding.root
    }

    private fun setBarChart() {


        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(8f, 0))
        entries.add(BarEntry(2f, 1))
        entries.add(BarEntry(5f, 2))
        entries.add(BarEntry(20f, 3))
        entries.add(BarEntry(15f, 4))
        entries.add(BarEntry(19f, 5))

        val barDataSet = BarDataSet(entries, "Intervention")

        val labels = ArrayList<String>()

        labels.add("18-Jan")
        labels.add("19-Jan")
        labels.add("20-Jan")
        labels.add("21-Jan")
        labels.add("22-Jan")
        labels.add("23-Jan")

        val data = BarData(labels, barDataSet)

        binding.barChart.data = data // set the data and list of lables into chart
        binding.barChart.setDescription("Intervention")

//        binding.barChart.description.text ="statut intervention"

        barDataSet.color = resources.getColor(R.color.colorAccent)

        binding.barChart.animateY(5000)
    }

     private fun setPieChart() {
         val pieEntries = arrayListOf<Entry>()
         pieEntries.add(Entry(30.0f,1))
         pieEntries.add(Entry(40.0f,2))
         pieEntries.add(Entry(60.0f,3))
         // Setup Pie Chart Animation
         binding.pieChart.animateXY(1000, 1000) // This 1000 is time that how much time piechart chreated

         // Setup PicChart Colors
         val pieDataSet = PieDataSet(pieEntries, "SR")

         val labels = ArrayList<String>()
         labels.add("En Cours")
         labels.add("Traitée")
         labels.add("Suspendue")

         val data = PieData(labels, pieDataSet)
         binding.pieChart.data = data

         binding.pieChart.setDescription("Statut Service")

         pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS)


         binding.pieChart.animateXY(1000,1000)
     }

}