package com.example.talan_app.adapters

import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.InterventionBinding
import com.example.talan_app.intervention.Intervention_Detail
import com.example.talan_app.model.Inter
import com.example.talan_app.model.ServiceList

import com.example.talan_app.view_model.Intervention_List_VM

class Adapter_List_intervention(private val context: Context ) : RecyclerView.Adapter<Adapter_List_intervention.Intervention_View_Holder>(){

     var list_intervention = ArrayList<Inter>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Intervention_View_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_intervention, parent,false)
    )



    override fun onBindViewHolder(holder: Adapter_List_intervention.Intervention_View_Holder, position: Int) {
        val interList = list_intervention[position]
        holder.bind(interList)
    }

    override fun getItemCount(): Int = list_intervention.size

    /////////////////////////////// Class Intervention_View_Holder  /////////////////////////////////////////////
    inner class Intervention_View_Holder( private val inter_Binding : InterventionBinding) :RecyclerView.ViewHolder(inter_Binding.root) {
        fun bind(inter:Inter){
            this.inter_Binding.interventionmodel = inter

            inter_Binding.cardintervention.setOnClickListener {
                val intent = Intent(context,Intervention_Detail::class.java)
                context.startActivity(intent)

            }


            if (inter.asset == null){
                inter_Binding.ActifInter.visibility = View.GONE
                inter_Binding.DescriptionInter.visibility = View.GONE

                inter_Binding.Site.visibility = View.VISIBLE
                inter_Binding.SiteInter.visibility = View.VISIBLE

            }else{
                inter_Binding.ActifInter.visibility = View.VISIBLE
                inter_Binding.DescriptionInter.visibility = View.VISIBLE

                inter_Binding.Site.visibility = View.GONE
                inter_Binding.SiteInter.visibility = View.GONE
            }

            inter_Binding.executePendingBindings()
        }

    }
    fun setData(newList: ArrayList<Inter>){
        list_intervention = newList
        notifyDataSetChanged()
    }



    fun addActif(serv : ArrayList<Inter>){
        list_intervention.addAll(serv)
    }

}
