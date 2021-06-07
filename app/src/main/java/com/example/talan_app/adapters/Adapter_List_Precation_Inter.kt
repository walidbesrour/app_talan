package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.PrecInterBinding
import com.example.talan_app.model.Wosa
import com.example.talan_app.model.Wosaf

class Adapter_List_Precation_Inter (private val context: Context) : RecyclerView.Adapter<Adapter_List_Precation_Inter.Prec_Holder>() {

    var list_Precaution = ArrayList<Wosa>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =Prec_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_precaution_inter , parent ,false)
    )

    override fun onBindViewHolder(holder: Adapter_List_Precation_Inter.Prec_Holder, position: Int) {
        val PrecList = list_Precaution[position]
        holder.bind(PrecList)
    }

    override fun getItemCount(): Int = list_Precaution.size

    inner class Prec_Holder(private val precInterBinding : PrecInterBinding) :RecyclerView.ViewHolder(precInterBinding.root) {
        fun bind(wosa: Wosa){
            this.precInterBinding.precmodel = wosa
            precInterBinding.executePendingBindings()
        }

    }
    fun setData(newList: ArrayList<Wosa>){
        list_Precaution = newList
        notifyDataSetChanged()
    }
}