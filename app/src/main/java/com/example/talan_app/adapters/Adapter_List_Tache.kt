package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.TacheBinding
import com.example.talan_app.view_model.InterventionsAssocieesVM
import com.example.talan_app.view_model.TacheVM

class Adapter_List_Tache(private val context: Context, private val list_Tache: ArrayList<TacheVM> ): RecyclerView.Adapter<Adapter_List_Tache.Tache_Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_Tache.Tache_Holder {

       val layoutInflater = LayoutInflater.from(parent.context)
        val tacheBinding : TacheBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_tache, parent,false)
        return Tache_Holder(tacheBinding)

    }

    override fun onBindViewHolder(holder: Adapter_List_Tache.Tache_Holder, position: Int) {

        val tacheList = list_Tache[position]
        holder.bind(tacheList)

    }

    override fun getItemCount(): Int = list_Tache.size

    /////////////////////////////// Class Tache_Holder  /////////////////////////////////////////////

    inner class Tache_Holder(private val tacheBinding: TacheBinding):RecyclerView.ViewHolder(tacheBinding.root) {

        fun bind(tacheVM :TacheVM){
            this.tacheBinding.tachemodel = tacheVM
            tacheBinding.executePendingBindings()

        }

    }
}