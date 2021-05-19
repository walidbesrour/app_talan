package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.PrecautionBinding
import com.example.talan_app.model.Hazard
import com.example.talan_app.model.Hazardprec

import com.example.talan_app.view_model.PrecautionVM


class Adapter_List_Precaution (private val context: Context ) : RecyclerView.Adapter<Adapter_List_Precaution.Precaution_Holder>() {

     var list_Precaution= ArrayList<Hazardprec>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =Precaution_Holder (
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_precaution,parent,false))




    override fun onBindViewHolder(holder: Adapter_List_Precaution.Precaution_Holder, position: Int) {
        val precaution = list_Precaution[position]
        holder.bind(precaution)
    }

    override fun getItemCount(): Int = list_Precaution.size

    /////////////////////////////// Class Precaution_Holder  /////////////////////////////////////////////
    inner class Precaution_Holder(private val precautionBinding : PrecautionBinding) : RecyclerView.ViewHolder(precautionBinding.root){
        fun bind(hazardprec: Hazardprec){
            this.precautionBinding.precautionmodel = hazardprec
            precautionBinding.executePendingBindings()
        }

    }

    fun setData(newList: ArrayList<Hazardprec>){
        list_Precaution = newList
        notifyDataSetChanged()
    }

    fun addActif(actif : ArrayList<Hazardprec>){
        list_Precaution.addAll(actif)
        notifyDataSetChanged()
    }
}