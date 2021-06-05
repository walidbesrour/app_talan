package com.example.talan_app.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.FavorisBinding
import com.example.talan_app.intervention.Intervention_Detail
import com.example.talan_app.model.Inter


class Adapter_List_favorisINTER(private val context: Context ) : RecyclerView.Adapter<Adapter_List_favorisINTER.FavorisHolder>() {


     var list_favoris = ArrayList<Inter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavorisHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_favoris_intervention, parent,false)
    )


    override fun onBindViewHolder(holder: Adapter_List_favorisINTER.FavorisHolder, position: Int) {
            val favList = list_favoris[position]
                 holder.bind(favList)
    }

    override fun getItemCount(): Int = list_favoris.size


    /////////////////////////////// Class Intervention_View_Holder  /////////////////////////////////////////////

    inner class FavorisHolder(private val favorisBinding :FavorisBinding) : RecyclerView.ViewHolder(favorisBinding.root){
        fun bind(inter:Inter){
            this.favorisBinding.favorismodel = inter

            val won = inter.wonum
            val wonum = "\"$won\""

            favorisBinding.cardintervention.setOnClickListener {
                val intent = Intent(context, Intervention_Detail::class.java)
                intent.putExtra("wonum",wonum)
                context.startActivity(intent)

            }
            if (inter.asset == null){
                favorisBinding.ActifInter.visibility = View.GONE
                favorisBinding.DescriptionInter.visibility = View.GONE

                favorisBinding.Site.visibility = View.VISIBLE
                favorisBinding.SiteInter.visibility = View.VISIBLE

            }else{
                favorisBinding.ActifInter.visibility = View.VISIBLE
                favorisBinding.DescriptionInter.visibility = View.VISIBLE

                favorisBinding.Site.visibility = View.GONE
                favorisBinding.SiteInter.visibility = View.GONE
            }
            favorisBinding.executePendingBindings()
        }

    }
    fun setData(newList: ArrayList<Inter>){
        list_favoris = newList
        notifyDataSetChanged()
    }

}

