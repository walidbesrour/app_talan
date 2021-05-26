package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.AssocieesBinding
import com.example.talan_app.model.ActifsListmember
import com.example.talan_app.model.Workorder
import com.example.talan_app.view_model.InterventionsAssocieesVM

class Adapter_List_InterventionsAssociees (private val context: Context ): RecyclerView.Adapter<Adapter_List_InterventionsAssociees.InterventionsAssociees_Holder>()  {


     var list_InterventionsAssociees = ArrayList<Workorder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = InterventionsAssociees_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_interventions_associees ,parent,false)
    )



    override fun onBindViewHolder(holder: Adapter_List_InterventionsAssociees.InterventionsAssociees_Holder, position: Int) {
        val  associeesList = list_InterventionsAssociees[position]
        holder.bind(associeesList)
    }

    override fun getItemCount(): Int = list_InterventionsAssociees.size
    /////////////////////////////// Class InterventionsAssociees_Holder  /////////////////////////////////////////////

    inner class InterventionsAssociees_Holder(private val associeesBinding :AssocieesBinding): RecyclerView.ViewHolder(associeesBinding.root){

        fun bind(workorder : Workorder){
            this.associeesBinding.associeesmodel = workorder
            associeesBinding.executePendingBindings()
        }

    }

    fun setData(newList: ArrayList<Workorder>){
        list_InterventionsAssociees = newList
        notifyDataSetChanged()
    }
}