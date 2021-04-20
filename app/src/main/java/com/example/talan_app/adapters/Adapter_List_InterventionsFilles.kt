package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.FillsBinding

import com.example.talan_app.view_model.InterventionsAssocieesVM

class Adapter_List_InterventionsFilles (private val context: Context, private val list_Interventionsfilles: ArrayList<InterventionsAssocieesVM> ): RecyclerView.Adapter<Adapter_List_InterventionsFilles.Filles_Holder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_InterventionsFilles.Filles_Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val InterventionsfillesBinding: FillsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_filles_intervention ,parent,false)
        return Filles_Holder(InterventionsfillesBinding)

    }

    override fun onBindViewHolder(holder: Adapter_List_InterventionsFilles.Filles_Holder, position: Int) {
        val  associeesList = list_Interventionsfilles[position]
        holder.bind(associeesList)
    }

    override fun getItemCount(): Int = list_Interventionsfilles.size
    /////////////////////////////// Class Filles_Holder  /////////////////////////////////////////////

    inner class Filles_Holder(private val fillsBinding : FillsBinding): RecyclerView.ViewHolder(fillsBinding.root){

        fun bind(fillesVM : InterventionsAssocieesVM){
            this.fillsBinding.fillsmodel = fillesVM
            fillsBinding.executePendingBindings()
        }

    }
}