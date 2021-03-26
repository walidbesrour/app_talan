package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.FavorisBinding

import com.example.talan_app.view_model.Favoris_intervention_VM


class Adapter_List_favorisINTER(private val context: Context, private val list_favoris: ArrayList<Favoris_intervention_VM>) : RecyclerView.Adapter<Adapter_List_favorisINTER.FavorisHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_favorisINTER.FavorisHolder {
           val layoutInflater = LayoutInflater.from(parent.context)
        val favorisBinding : FavorisBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list_favoris_intervention, parent,false)
//
        return FavorisHolder(favorisBinding)

    }

    override fun onBindViewHolder(holder: Adapter_List_favorisINTER.FavorisHolder, position: Int) {
            val favList = list_favoris[position]
                 holder.bind(favList)
    }

    override fun getItemCount(): Int = list_favoris.size


    /////////////////////////////// Class Intervention_View_Holder  /////////////////////////////////////////////

    class FavorisHolder(private val favorisBinding :FavorisBinding) : RecyclerView.ViewHolder(favorisBinding.root){
        fun bind(favoris_intervention_VM : Favoris_intervention_VM){
            this.favorisBinding.favorismodel = favoris_intervention_VM
            favorisBinding.executePendingBindings()
        }

    }
}

