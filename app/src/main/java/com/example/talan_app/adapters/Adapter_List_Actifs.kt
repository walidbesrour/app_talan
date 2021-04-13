package com.example.talan_app.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.MainActivity
import com.example.talan_app.R
import com.example.talan_app.databinding.ActifBinding
import com.example.talan_app.detail.Actif_Detail

import com.example.talan_app.view_model.Actif_List_VM

class Adapter_List_Actifs(private val context: Context, private val list_actif: ArrayList<Actif_List_VM> ):RecyclerView.Adapter<Adapter_List_Actifs.Actif_View_Holder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_Actifs.Actif_View_Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val  actifBinding:ActifBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list_actifs,parent,false)
        return Actif_View_Holder(actifBinding)
    }

    override fun onBindViewHolder(holder: Adapter_List_Actifs.Actif_View_Holder, position: Int) {
        val actifli = list_actif[position]
        holder.bind(actifli)
    }

    override fun getItemCount(): Int = list_actif.size


    /////////////////////////////// Class Actif_View_Holder  /////////////////////////////////////////////
    inner class Actif_View_Holder(val actifBinding : ActifBinding) :RecyclerView.ViewHolder(actifBinding.root){

        fun bind (actif_List_VM: Actif_List_VM)
        {

            this.actifBinding.actifmodel = actif_List_VM
            if (actif_List_VM.children== false){
                actifBinding.filsActif.visibility = View.GONE
            }


            actifBinding.filsActif.setOnClickListener {
                    val p : Int = adapterPosition
               actif_List_VM.filsActifList(p)
            }
            actifBinding.cardbtn.setOnClickListener {
                println("/////////////////////////////////")
//                val p : Int = adapterPosition
                val i = Intent(context , Actif_Detail::class.java)
                context.startActivity(i)
//                    overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
//                finish()
//                actif_List_VM.detailActif(p)
            }


            actifBinding.executePendingBindings()


        }
    }
}