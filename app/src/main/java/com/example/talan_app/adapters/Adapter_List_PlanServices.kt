package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.PlanServiceBinding
import com.example.talan_app.view_model.ServicePlanVM

class Adapter_List_PlanServices(private val context: Context, private val list_ServicePlan: ArrayList<ServicePlanVM>) : RecyclerView.Adapter<Adapter_List_PlanServices.PlanServices_Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_PlanServices.PlanServices_Holder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val planServiceBinding : PlanServiceBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_services, parent,false)
        return PlanServices_Holder(planServiceBinding)

    }

    override fun onBindViewHolder(holder: Adapter_List_PlanServices.PlanServices_Holder, position: Int) {

        val servList = list_ServicePlan[position]
        holder.bind(servList)
    }

    override fun getItemCount(): Int = list_ServicePlan.size

    /////////////////////////////// Class PlanServices_Holder  /////////////////////////////////////////////

    inner class PlanServices_Holder( private val planServiceBinding : PlanServiceBinding) :RecyclerView.ViewHolder(planServiceBinding.root) {
        fun bind(servicePlanVM:ServicePlanVM){

            this.planServiceBinding.planservicemodel = servicePlanVM
            planServiceBinding.executePendingBindings()
        }

    }

}