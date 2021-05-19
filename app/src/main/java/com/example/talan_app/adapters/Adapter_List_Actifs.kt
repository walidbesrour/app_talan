package com.example.talan_app.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.Menu_Activity
import com.example.talan_app.R
import com.example.talan_app.actifs.Actif_Detail
import com.example.talan_app.databinding.ActifBinding
import com.example.talan_app.intervention.Intervention_Detail
import com.example.talan_app.menu_fragments.ActifFragment
import com.example.talan_app.model.ActifsListmember


class Adapter_List_Actifs(var context: Context) :RecyclerView.Adapter<Adapter_List_Actifs.Actif_View_Holder>() {


    var list_actif = ArrayList<ActifsListmember>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Actif_View_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_actifs,parent,false ))



    override fun onBindViewHolder(holder: Adapter_List_Actifs.Actif_View_Holder, position: Int) {

        var act = list_actif[position]
        holder.bind(act)



    }

    override fun getItemCount(): Int = list_actif.size


    /////////////////////////////// Class Actif_View_Holder  /////////////////////////////////////////////
    inner class Actif_View_Holder(val actifBinding : ActifBinding) :RecyclerView.ViewHolder(actifBinding.root){

        fun bind(actifsListmember :ActifsListmember){
            this.actifBinding.actifmodel = actifsListmember


    ////////////////////////////// go to actif Detail ///////////////////////////
            actifBinding.cardbtn.setOnClickListener {
                val assetnumD = actifsListmember.assetnum
                val assetD = "\"$assetnumD\""
                val siteid = actifsListmember.siteid

                val intent = Intent(context, Actif_Detail::class.java)
                intent.putExtra("assetnumD",assetD)
                intent.putExtra("siteidD",siteid)
                context.startActivity(intent)
            }

            if (actifsListmember.children){
                actifBinding.filsActif.visibility = View.VISIBLE
            }
            else
                actifBinding.filsActif.visibility = View.GONE

        ////////////////////////////// go to actif children ///////////////////////////

            actifBinding.filsActif.setOnClickListener {

//                val p : Int = adapterPosition
                val assetnum = actifsListmember.assetnum
                val siteid = actifsListmember.siteid
                Log.e("TAG parent", assetnum )

                val intent = Intent(context, Menu_Activity::class.java)
                intent.putExtra("assetnum",assetnum)
                intent.putExtra("siteid",siteid)
                context.startActivity(intent)
            }

            actifBinding.executePendingBindings()
        }


    }

    fun setData(newList: ArrayList<ActifsListmember>){
        list_actif = newList
        notifyDataSetChanged()
    }



    fun addActif(actif : ArrayList<ActifsListmember>){
        list_actif.addAll(actif)
    }

}
