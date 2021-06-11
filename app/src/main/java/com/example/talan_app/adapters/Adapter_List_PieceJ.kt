package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.PieceBinding
import com.example.talan_app.model.Pis


class Adapter_List_PieceJ (private val context: Context) : RecyclerView.Adapter<Adapter_List_PieceJ.Piece_Holder>(){
    var list_piece = ArrayList<Pis>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =Piece_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_piece_joint,parent,false)
    )

    override fun onBindViewHolder(holder: Adapter_List_PieceJ.Piece_Holder, position: Int) {
        val pieceList = list_piece[position]
        holder.bind(pieceList)
    }

    override fun getItemCount(): Int = list_piece.size

    inner class Piece_Holder(private val pieceBinding : PieceBinding): RecyclerView.ViewHolder(pieceBinding.root){
        fun bind(piece : Pis){
            this.pieceBinding.piecemodel = piece
            pieceBinding.executePendingBindings()
        }
    }

    fun setData(newList: ArrayList<Pis>){
        list_piece = newList
        notifyDataSetChanged()
    }
}