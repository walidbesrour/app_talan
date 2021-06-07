package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.RisInterBinding
import com.example.talan_app.model.Hazard
import com.example.talan_app.model.Wosaf


class Adapter_List_RisqueInter (private val context: Context) :RecyclerView.Adapter<Adapter_List_RisqueInter.RisInter_Holder>(){

    var list_Risque = ArrayList<Wosaf>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =RisInter_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_risque_inter , parent ,false)
    )

    override fun onBindViewHolder(holder: Adapter_List_RisqueInter.RisInter_Holder, position: Int) {
        val risqueList = list_Risque[position]
        holder.bind(risqueList)
    }

    override fun getItemCount(): Int= list_Risque.size

    inner class RisInter_Holder(private val risInterBinding : RisInterBinding) : RecyclerView.ViewHolder(risInterBinding.root){
        fun bind(wosaf:Wosaf){
            this.risInterBinding.interisquemodel = wosaf
            risInterBinding.executePendingBindings()

        }



    }
    fun setData(newList: ArrayList<Wosaf>){
        list_Risque = newList
        notifyDataSetChanged()
    }
}