package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.DoeuvreBinding
import com.example.talan_app.view_model.MainDoeuvreVM

class Adapter_List_MainDoeuvre (private val context: Context, private val list_MainDoeuvre: ArrayList<MainDoeuvreVM>) : RecyclerView.Adapter<Adapter_List_MainDoeuvre.MainDoeuvre_Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_MainDoeuvre.MainDoeuvre_Holder {

         val layoutInflater = LayoutInflater.from(parent.context)
        val doeuvreBinding : DoeuvreBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_main_oeuvre, parent,false)

        return MainDoeuvre_Holder(doeuvreBinding)


    }

    override fun onBindViewHolder(holder: Adapter_List_MainDoeuvre.MainDoeuvre_Holder, position: Int) {

            val doeuvreList = list_MainDoeuvre[position]
        holder.bind(doeuvreList)

    }

    override fun getItemCount(): Int = list_MainDoeuvre.size

    /////////////////////////////// Class MainDoeuvre_Holder  /////////////////////////////////////////////
      inner class MainDoeuvre_Holder( private val doeuvreBinding : DoeuvreBinding) :RecyclerView.ViewHolder(doeuvreBinding.root){
          fun bind(mainDoeuvreVM :MainDoeuvreVM){
              this.doeuvreBinding.doeuvremodel = mainDoeuvreVM
              doeuvreBinding.executePendingBindings()

          }

      }
}