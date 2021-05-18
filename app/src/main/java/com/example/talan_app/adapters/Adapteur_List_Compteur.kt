package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.CompteurBinding
import com.example.talan_app.model.*
import com.example.talan_app.view_model.Compteur_List_VM

class Adapteur_List_Compteur (private val context: Context): RecyclerView.Adapter<Adapteur_List_Compteur.Compteur_Holder>() {

      var list_compteur = ArrayList<Assetmeter>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Compteur_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_compteur,parent,false))





    override fun onBindViewHolder(holder: Adapteur_List_Compteur.Compteur_Holder, position: Int) {
         val compteurList = list_compteur[position]
                     holder.bind(compteurList)
    }

    override fun getItemCount(): Int = list_compteur.size

    /////////////////////////////// Class Compteur_Holder  /////////////////////////////////////////////
    inner class Compteur_Holder(private val compteurBinding : CompteurBinding) :RecyclerView.ViewHolder(compteurBinding.root){
           fun bind(assetmeter: Assetmeter){
                 this.compteurBinding.compteurmodel = assetmeter
                 compteurBinding.executePendingBindings()

        }

}
    fun setData(newList: ArrayList<Assetmeter>){
        list_compteur = newList
        notifyDataSetChanged()
    }
}