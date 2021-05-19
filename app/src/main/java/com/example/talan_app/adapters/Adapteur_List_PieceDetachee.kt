package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.DetacheeBinding
import com.example.talan_app.model.Piece

class Adapteur_List_PieceDetachee (private val context: Context): RecyclerView.Adapter<Adapteur_List_PieceDetachee.PieceD_Holder>(){

     var list_PieceD = ArrayList<Piece>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PieceD_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_piece_detachee,parent,false))

    override fun onBindViewHolder(holder: Adapteur_List_PieceDetachee.PieceD_Holder, position: Int) {
      val piecelist = list_PieceD[position]
        holder.bind(piecelist)

    }

    override fun getItemCount(): Int = list_PieceD.size


    /////////////////////////////// Class PieceD_Holder  /////////////////////////////////////////////
    inner class PieceD_Holder(private val detacheeBinding  : DetacheeBinding):RecyclerView.ViewHolder(detacheeBinding.root){

        fun bind(piece: Piece){
            this.detacheeBinding.piecemodel = piece
            detacheeBinding.executePendingBindings()
        }

    }
    fun setData(newList: ArrayList<Piece>){
        list_PieceD = newList
        notifyDataSetChanged()
    }

}