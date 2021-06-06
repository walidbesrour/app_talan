package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.TacheBinding
import com.example.talan_app.model.Inter
import com.example.talan_app.model.Woactivity

class Adapter_List_Tache(private val context: Context ): RecyclerView.Adapter<Adapter_List_Tache.Tache_Holder>() {

    var list_Tache = ArrayList<Woactivity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Tache_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_tache, parent,false)
    )


    override fun onBindViewHolder(holder: Adapter_List_Tache.Tache_Holder, position: Int) {

        val tacheList = list_Tache[position]
        holder.bind(tacheList)

    }

    override fun getItemCount(): Int = list_Tache.size

    /////////////////////////////// Class Tache_Holder  /////////////////////////////////////////////

    inner class Tache_Holder(private val tacheBinding: TacheBinding):RecyclerView.ViewHolder(tacheBinding.root) {

        fun bind(woactivity: Woactivity ){
            this.tacheBinding.tachemodel = woactivity
            tacheBinding.executePendingBindings()

        }

    }

    fun setData(newList: ArrayList<Woactivity>){
        list_Tache = newList
        notifyDataSetChanged()
    }
}