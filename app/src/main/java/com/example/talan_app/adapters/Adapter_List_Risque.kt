package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.RisqueBinding
import com.example.talan_app.model.ActifsListmember
import com.example.talan_app.model.Hazard
import com.example.talan_app.model.Piece
import com.example.talan_app.view_model.RisqueVM

class Adapter_List_Risque(private val context: Context) : RecyclerView.Adapter<Adapter_List_Risque.Risque_Holder>() {

     var list_Risque = ArrayList<Hazard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =Risque_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_risque,parent,false))




    override fun onBindViewHolder(holder: Adapter_List_Risque.Risque_Holder, position: Int) {
            val risqueList = list_Risque[position]
               holder.bind(risqueList)
    }

    override fun getItemCount(): Int = list_Risque.size

    /////////////////////////////// Class Risque_Holder  /////////////////////////////////////////////
    inner class Risque_Holder(private val risqueBinding : RisqueBinding) : RecyclerView.ViewHolder(risqueBinding.root){
        fun bind(hazard: Hazard){
            this.risqueBinding.risquemodel = hazard
            risqueBinding.executePendingBindings()
        }

    }
    fun setData(newList: ArrayList<Hazard>){
        list_Risque = newList
        notifyDataSetChanged()
    }

    fun addActif(actif : ArrayList<Hazard>){
        list_Risque.addAll(actif)
        notifyDataSetChanged()
    }

}