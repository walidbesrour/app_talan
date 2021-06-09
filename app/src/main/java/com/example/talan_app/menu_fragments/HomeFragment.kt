 package com.example.talan_app.menu_fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.FragmentHomeBinding
import com.example.talan_app.repository.RetrofitRepositoryService
import com.example.talan_app.view_model.Service_ListFactory_VM
import com.example.talan_app.view_model.Service_List_VM
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import java.text.DateFormat
import java.util.*

 class HomeFragment : Fragment() {

     private lateinit var binding: FragmentHomeBinding
     private lateinit var viewModel: Service_List_VM

     var Cours :Float  = 1.0f
     var Traitee :Float  = 1.0f
     var Suspendue :Float  = 1.0f
     var FERME :Float  = 1.0f



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        val repository = RetrofitRepositoryService()
        val viewModelFactory = Service_ListFactory_VM(repository)

        val sharedPreferences = this.getActivity()!!.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Service_List_VM::class.java)

        if (Apikey != null) {
            viewModel.getStatusService(Apikey,"status")
            viewModel.myResponseStatus.observe(viewLifecycleOwner, androidx.lifecycle.Observer { Myresponse ->
                if (Myresponse.isSuccessful) {

                    val siz = Myresponse.body()!!.member.size - 1

                    for (i in 0..siz){
//
                        if (Myresponse.body()!!.member[i].status == "FERME"){
                            FERME += 1.0f

                        }else if (Myresponse.body()!!.member[i].status == "ENCRS"){
                            Cours += 1.0f

                        }else if (Myresponse.body()!!.member[i].status == "RESOLU"){
                            Traitee += 1.0f

                        }else if (Myresponse.body()!!.member[i].status == "FILATT"){
                            Suspendue += 1.0f


                        }else{

                        }

                    }


                    setPieChart(Cours,Traitee,Suspendue,FERME)

                } else {
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    println("+++++++++++++++++++++++++++++++++++++")
                }
            })
        }

        setBarChart()


//        val calendar: Calendar = Calendar.getInstance()
//        val currentDate: String = DateFormat.getDateInstance(DateFormat.AM_PM_FIELD).format(calendar.getTime())

//        Log.e("date to day ","********* $currentDate")



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

     private fun setPieChart(CR : Float,TR : Float,SU : Float,FR : Float) {
         val pieEntries = arrayListOf<Entry>()
         pieEntries.add(Entry(CR,1))
         pieEntries.add(Entry(TR,2))
         pieEntries.add(Entry(SU,3))
         pieEntries.add(Entry(FR,4))
         // Setup Pie Chart Animation
         binding.pieChart.animateXY(1000, 1000) // This 1000 is time that how much time piechart chreated

         // Setup PicChart Colors
         val pieDataSet = PieDataSet(pieEntries, "Statut Service")

         val labels = ArrayList<String>()
         labels.add("En Cours")
         labels.add("Traitée")
         labels.add("Suspendue")
         labels.add("FERME")

         val data = PieData(labels, pieDataSet)

         data.setValueTextSize(10f)

         binding.pieChart.data = data

         binding.pieChart.setDescription("")

         pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS)


//         binding.pieChart.animateXY(1000,1000)
     }

}