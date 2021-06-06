package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.PlanServiceBinding
import com.example.talan_app.model.Assig
import com.example.talan_app.model.Serv

class Adapter_List_PlanServices(private val context: Context) : RecyclerView.Adapter<Adapter_List_PlanServices.PlanServices_Holder>() {


    var list_ServicePlan= ArrayList<Serv>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlanServices_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_services, parent,false)
    )



    override fun onBindViewHolder(holder: Adapter_List_PlanServices.PlanServices_Holder, position: Int) {

        val servList = list_ServicePlan[position]
        holder.bind(servList)
    }

    override fun getItemCount(): Int = list_ServicePlan.size

    /////////////////////////////// Class PlanServices_Holder  /////////////////////////////////////////////

    inner class PlanServices_Holder( private val planServiceBinding : PlanServiceBinding) :RecyclerView.ViewHolder(planServiceBinding.root) {
        fun bind(serv:Serv){

            this.planServiceBinding.planservicemodel = serv
            planServiceBinding.executePendingBindings()
        }

    }

    fun setData(newList: ArrayList<Serv>){
        list_ServicePlan = newList
        notifyDataSetChanged()
    }

}