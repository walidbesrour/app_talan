package com.example.talan_app.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.ServiceBinding
import com.example.talan_app.model.ServiceList
import com.example.talan_app.services.Service_Detail

class Adapter_List_Service(var context: Context  ) : RecyclerView.Adapter<Adapter_List_Service.Service_View_Holder>() {


    var list_service = ArrayList<ServiceList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Service_View_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_service,parent,false))




    override fun onBindViewHolder(holder: Adapter_List_Service.Service_View_Holder, position: Int) {
            val serviceList = list_service[position]
             holder.bind(serviceList)
    }

    override fun getItemCount(): Int = list_service.size



    /////////////////////////////// Class Service_View_Holder  /////////////////////////////////////////////
    inner class Service_View_Holder(private val service_Binding : ServiceBinding) :RecyclerView.ViewHolder(service_Binding.root){
        fun bind(service: ServiceList){
            this.service_Binding.servicemodel = service


            service_Binding.cardbtnservice.setOnClickListener {
                val intent = Intent(context,Service_Detail::class.java)
                context.startActivity(intent)
            }

            if (service.asset == null){

                service_Binding.ActifServ1.visibility = View.GONE
                service_Binding.ActifServ.visibility = View.GONE
                service_Binding.descriptionActif.visibility = View.GONE

                service_Binding.SiteServ1.visibility = View.VISIBLE
                service_Binding.SiteServ.visibility = View.VISIBLE
            }else{
                service_Binding.ActifServ1.visibility = View.VISIBLE
                service_Binding.ActifServ.visibility = View.VISIBLE
                service_Binding.descriptionActif.visibility = View.VISIBLE

                service_Binding.SiteServ1.visibility = View.GONE
                service_Binding.SiteServ.visibility = View.GONE
            }

            service_Binding.executePendingBindings()
        }

    }

    fun setData(newList: ArrayList<ServiceList>){
        list_service = newList
        notifyDataSetChanged()
    }



    fun addActif(serv : ArrayList<ServiceList>){
        list_service.addAll(serv)
    }

}
//