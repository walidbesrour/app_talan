package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.RealisationBinding
import com.example.talan_app.model.Assig


class Adapter_List_Realisation (private val context: Context) : RecyclerView.Adapter<Adapter_List_Realisation.Realisation_Holder>(){


    var list_Realisation = ArrayList<Assig>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =Realisation_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_realisation, parent,false)
    )





    override fun onBindViewHolder(holder: Adapter_List_Realisation.Realisation_Holder, position: Int) {
        val interList = list_Realisation[position]
        holder.bind(interList)
    }

    override fun getItemCount(): Int = list_Realisation.size

    /////////////////////////////// Class Realisation_Holder  /////////////////////////////////////////////

    inner class Realisation_Holder(private val realisationBinding: RealisationBinding):RecyclerView.ViewHolder(realisationBinding.root){

        fun bind(assig: Assig){
            this.realisationBinding.realisationmodule = assig


            this.realisationBinding.libRelative.setOnClickListener {
                if ( realisationBinding.invisibleView.visibility == View.VISIBLE){
                    realisationBinding.invisibleView.visibility = View.GONE
                }else{
                    realisationBinding.invisibleView.visibility = View.VISIBLE
                }


            }

            realisationBinding.executePendingBindings()

        }

    }

    fun setData(newList: ArrayList<Assig>){
        list_Realisation = newList
        notifyDataSetChanged()
    }
}

