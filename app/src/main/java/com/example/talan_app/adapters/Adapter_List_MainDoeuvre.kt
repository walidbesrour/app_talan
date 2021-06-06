package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.DoeuvreBinding
import com.example.talan_app.model.Assig
import com.example.talan_app.model.Inter
import com.example.talan_app.model.Woactivity

class Adapter_List_MainDoeuvre (private val context: Context) : RecyclerView.Adapter<Adapter_List_MainDoeuvre.MainDoeuvre_Holder>(){

    var list_MainDoeuvre = ArrayList<Assig>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MainDoeuvre_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_main_oeuvre, parent,false)
    )


    override fun onBindViewHolder(holder: Adapter_List_MainDoeuvre.MainDoeuvre_Holder, position: Int) {

            val doeuvreList = list_MainDoeuvre[position]
        holder.bind(doeuvreList)

    }

    override fun getItemCount(): Int = list_MainDoeuvre.size

    /////////////////////////////// Class MainDoeuvre_Holder  /////////////////////////////////////////////
      inner class MainDoeuvre_Holder( private val doeuvreBinding : DoeuvreBinding) :RecyclerView.ViewHolder(doeuvreBinding.root){
          fun bind(assig :Assig){
              this.doeuvreBinding.doeuvremodel = assig
              doeuvreBinding.executePendingBindings()

          }

      }

    fun setData(newList: ArrayList<Assig>){
        list_MainDoeuvre = newList
        notifyDataSetChanged()
    }
}