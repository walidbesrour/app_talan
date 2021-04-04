package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.PrecautionBinding

import com.example.talan_app.view_model.PrecautionVM


class Adapter_List_Precaution (private val context: Context, private val list_Precaution: ArrayList<PrecautionVM> ) : RecyclerView.Adapter<Adapter_List_Precaution.Precaution_Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_Precaution.Precaution_Holder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val precautionBinding: PrecautionBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_precaution,parent,false)
        return Precaution_Holder(precautionBinding)
    }

    override fun onBindViewHolder(holder: Adapter_List_Precaution.Precaution_Holder, position: Int) {
        val precaution = list_Precaution[position]
        holder.bind(precaution)
    }

    override fun getItemCount(): Int = list_Precaution.size

    /////////////////////////////// Class Precaution_Holder  /////////////////////////////////////////////
    inner class Precaution_Holder(private val precautionBinding : PrecautionBinding) : RecyclerView.ViewHolder(precautionBinding.root){
        fun bind(precautionVM: PrecautionVM){
            this.precautionBinding.precautionmodel = precautionVM
            precautionBinding.executePendingBindings()
        }

    }


}