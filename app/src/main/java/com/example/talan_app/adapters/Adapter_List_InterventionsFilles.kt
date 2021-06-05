package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.FillsBinding
import com.example.talan_app.model.Inter

import com.example.talan_app.view_model.InterventionsAssocieesVM

class Adapter_List_InterventionsFilles (private val context: Context ): RecyclerView.Adapter<Adapter_List_InterventionsFilles.Filles_Holder>()  {

     var list_Interventionsfilles = ArrayList<Inter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =Filles_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_filles_intervention ,parent,false)
    )




    override fun onBindViewHolder(holder: Adapter_List_InterventionsFilles.Filles_Holder, position: Int) {
        val  associeesList = list_Interventionsfilles[position]
        holder.bind(associeesList)
    }

    override fun getItemCount(): Int = list_Interventionsfilles.size
    /////////////////////////////// Class Filles_Holder  /////////////////////////////////////////////

    inner class Filles_Holder(private val fillsBinding : FillsBinding): RecyclerView.ViewHolder(fillsBinding.root){

        fun bind(inter:Inter){
            this.fillsBinding.fillsmodel = inter
            fillsBinding.executePendingBindings()
        }

    }
    fun setData(newList: ArrayList<Inter>){
        list_Interventionsfilles = newList
        notifyDataSetChanged()
    }
}