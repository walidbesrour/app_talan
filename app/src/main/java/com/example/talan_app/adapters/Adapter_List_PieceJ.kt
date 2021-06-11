package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.PieceBinding
import com.example.talan_app.model.Pis
import com.google.android.material.textfield.TextInputEditText
import com.squareup.picasso.Picasso


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

            pieceBinding.Document.setOnClickListener {
                var lien1 = piece.describedBy.fileName
                val lien = "http://192.168.111.10:80/Attachments/$lien1"


                    val view = View.inflate(context, R.layout.dialog_image_piece,null)
                    val builder = AlertDialog.Builder(context)
                    builder.setView(view)

                    val dialog = builder.create()
                    dialog.show()
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                    dialog.setCancelable(false)
                    val img = dialog.findViewById<ImageView>(R.id.imagePiece) as ImageView
                Picasso.get().load(lien).into(img)
//                    textView.text= lien
                    dialog.findViewById<Button>(R.id.btnokPiece)?.setOnClickListener { dialog.dismiss() }


            }

            pieceBinding.executePendingBindings()
        }
    }

    fun setData(newList: ArrayList<Pis>){
        list_piece = newList
        notifyDataSetChanged()
    }

}