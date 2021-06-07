package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.OutilBinding
import com.example.talan_app.model.OutilInter
import com.example.talan_app.model.Serv

class Adapter_List_Outil (private val context: Context) : RecyclerView.Adapter<Adapter_List_Outil.Outil_Holder>(){


    var list_outil= ArrayList<OutilInter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Outil_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_outils, parent,false)
    )



    override fun onBindViewHolder(holder: Adapter_List_Outil.Outil_Holder, position: Int) {

            val outilList1 = list_outil[position]
        holder.bind(outilList1)

    }

    override fun getItemCount(): Int = list_outil.size

    /////////////////////////////// Class Outil_Holder  /////////////////////////////////////////////
      inner class Outil_Holder( private val outilBinding : OutilBinding) :RecyclerView.ViewHolder(outilBinding.root){
          fun bind(outil : OutilInter){
              this.outilBinding.outilmodel = outil
              outilBinding.executePendingBindings()

          }

      }

    fun setData(newList: ArrayList<OutilInter>){
        list_outil = newList
        notifyDataSetChanged()
    }
}