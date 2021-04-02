package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.CompteurBinding
import com.example.talan_app.view_model.Compteur_List_VM

class Adapteur_List_Compteur (private val context: Context, private val list_compteur: ArrayList<Compteur_List_VM> ): RecyclerView.Adapter<Adapteur_List_Compteur.Compteur_Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapteur_List_Compteur.Compteur_Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val compteurBinding:CompteurBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_compteur,parent,false)
        return Compteur_Holder(compteurBinding)
    }

    override fun onBindViewHolder(holder: Adapteur_List_Compteur.Compteur_Holder, position: Int) {
         val compteurList = list_compteur[position]
                     holder.bind(compteurList)
    }

    override fun getItemCount(): Int = list_compteur.size

    /////////////////////////////// Class Compteur_Holder  /////////////////////////////////////////////
    inner class Compteur_Holder(private val compteurBinding : CompteurBinding) :RecyclerView.ViewHolder(compteurBinding.root){
           fun bind(compteur_List_VM: Compteur_List_VM){
                 this.compteurBinding.compteurmodel = compteur_List_VM
                 compteurBinding.executePendingBindings()

        }

}
}