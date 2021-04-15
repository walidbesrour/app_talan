package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.AssocieesBinding
import com.example.talan_app.view_model.InterventionsAssocieesVM

class Adapter_List_InterventionsAssociees (private val context: Context, private val list_InterventionsAssociees: ArrayList<InterventionsAssocieesVM> ): RecyclerView.Adapter<Adapter_List_InterventionsAssociees.InterventionsAssociees_Holder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_InterventionsAssociees.InterventionsAssociees_Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val InterventionsAssocieesBinding: AssocieesBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_interventions_associees ,parent,false)
        return InterventionsAssociees_Holder(InterventionsAssocieesBinding)

    }

    override fun onBindViewHolder(holder: Adapter_List_InterventionsAssociees.InterventionsAssociees_Holder, position: Int) {
        val  associeesList = list_InterventionsAssociees[position]
        holder.bind(associeesList)
    }

    override fun getItemCount(): Int = list_InterventionsAssociees.size
    /////////////////////////////// Class InterventionsAssociees_Holder  /////////////////////////////////////////////

    inner class InterventionsAssociees_Holder(private val associeesBinding :AssocieesBinding): RecyclerView.ViewHolder(associeesBinding.root){

        fun bind(asssocieesVM : InterventionsAssocieesVM){
            this.associeesBinding.associeesmodel = asssocieesVM
            associeesBinding.executePendingBindings()
        }

    }
}