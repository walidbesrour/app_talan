package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.FilsActifBinding

import com.example.talan_app.view_model.FilsActif_List_VM

class Adapter_List_FilsActifs(private val context: Context, private val list_filsactif: ArrayList<FilsActif_List_VM> ):RecyclerView.Adapter<Adapter_List_FilsActifs.FilsActifHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_FilsActifs.FilsActifHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

            val FilsActifBinding: FilsActifBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_fils_detail,parent,false)
        return FilsActifHolder(FilsActifBinding)

    }

    override fun onBindViewHolder(holder: Adapter_List_FilsActifs.FilsActifHolder, position: Int) {
        val detailfis =list_filsactif[position]
        holder.bind(detailfis)
    }

    override fun getItemCount(): Int = list_filsactif.size


    /////////////////////////////// Class FilsActifHolder  /////////////////////////////////////////////

    inner class FilsActifHolder(private val filsActifBinding: FilsActifBinding) : RecyclerView.ViewHolder(filsActifBinding.root){
        fun bind(fils : FilsActif_List_VM){
            this.filsActifBinding.filsactifmodel = fils
            filsActifBinding.executePendingBindings()

        }
    }
}