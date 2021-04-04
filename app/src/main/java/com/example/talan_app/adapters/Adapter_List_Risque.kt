package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.RisqueBinding
import com.example.talan_app.view_model.RisqueVM

class Adapter_List_Risque(private val context: Context, private val list_Risque: ArrayList<RisqueVM> ) : RecyclerView.Adapter<Adapter_List_Risque.Risque_Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_Risque.Risque_Holder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val risqueBinding: RisqueBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_risque,parent,false)
        return Risque_Holder(risqueBinding)
    }

    override fun onBindViewHolder(holder: Adapter_List_Risque.Risque_Holder, position: Int) {
            val risqueList = list_Risque[position]
               holder.bind(risqueList)
    }

    override fun getItemCount(): Int = list_Risque.size

    /////////////////////////////// Class Risque_Holder  /////////////////////////////////////////////
    inner class Risque_Holder(private val risqueBinding : RisqueBinding) : RecyclerView.ViewHolder(risqueBinding.root){
        fun bind(risqueVM: RisqueVM){
            this.risqueBinding.risquemodel = risqueVM
            risqueBinding.executePendingBindings()
        }

    }


}