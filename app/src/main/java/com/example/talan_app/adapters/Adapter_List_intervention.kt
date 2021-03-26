package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.InterventionBinding
import com.example.talan_app.view_model.Intervention_List_VM

class Adapter_List_intervention(private val context: Context , private val list_intervention: ArrayList<Intervention_List_VM>) : RecyclerView.Adapter<Adapter_List_intervention.Intervention_View_Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_intervention.Intervention_View_Holder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val interventionBinding : InterventionBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list_intervention, parent,false)

        return Intervention_View_Holder(interventionBinding)
    }

    override fun onBindViewHolder(holder: Adapter_List_intervention.Intervention_View_Holder, position: Int) {
        val interList = list_intervention[position]
        holder.bind(interList)
    }

    override fun getItemCount(): Int = list_intervention.size

    /////////////////////////////// Class Intervention_View_Holder  /////////////////////////////////////////////
    class Intervention_View_Holder( private val inter_Binding : InterventionBinding) :RecyclerView.ViewHolder(inter_Binding.root) {
        fun bind(intervention_List_VM:Intervention_List_VM){
            this.inter_Binding.interventionmodel = intervention_List_VM
            inter_Binding.executePendingBindings()
        }

    }

}
