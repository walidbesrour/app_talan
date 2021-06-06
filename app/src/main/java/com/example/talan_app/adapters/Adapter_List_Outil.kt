package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.OutilBinding
import com.example.talan_app.view_model.OutilVM

class Adapter_List_Outil (private val context: Context, private val list_outil: ArrayList<OutilVM>) : RecyclerView.Adapter<Adapter_List_Outil.Outil_Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_Outil.Outil_Holder {

         val layoutInflater = LayoutInflater.from(parent.context)
        val outilBinding : OutilBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_outils, parent,false)

        return Outil_Holder(outilBinding)


    }

    override fun onBindViewHolder(holder: Adapter_List_Outil.Outil_Holder, position: Int) {

            val outilList1 = list_outil[position]
        holder.bind(outilList1)

    }

    override fun getItemCount(): Int = list_outil.size

    /////////////////////////////// Class Outil_Holder  /////////////////////////////////////////////
      inner class Outil_Holder( private val outilBinding : OutilBinding) :RecyclerView.ViewHolder(outilBinding.root){
          fun bind(outilVM : OutilVM){
              this.outilBinding.outilmodel = outilVM
              outilBinding.executePendingBindings()

          }

      }
}