package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.ServiceBinding
import com.example.talan_app.view_model.Service_List_VM

class Adapter_List_Service(private val context: Context , private val list_service : ArrayList<Service_List_VM>) : RecyclerView.Adapter<Adapter_List_Service.Service_View_Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_Service.Service_View_Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val serviceBinding:ServiceBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list_service,parent,false)

        return Service_View_Holder(serviceBinding)
    }

    override fun onBindViewHolder(holder: Adapter_List_Service.Service_View_Holder, position: Int) {
            val serviceList = list_service[position]
             holder.bind(serviceList)
    }

    override fun getItemCount(): Int = list_service.size



    /////////////////////////////// Class Service_View_Holder  /////////////////////////////////////////////
    inner class Service_View_Holder(private val service_Binding : ServiceBinding) :RecyclerView.ViewHolder(service_Binding.root){
        fun bind(service_List_VM: Service_List_VM){
            this.service_Binding.servicemodel = service_List_VM
            service_Binding.executePendingBindings()
        }

    }

}
//