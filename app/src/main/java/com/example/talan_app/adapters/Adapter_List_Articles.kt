package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.ArticlesBinding
import com.example.talan_app.model.Artic
import com.example.talan_app.model.Assig

class Adapter_List_Articles(private val context: Context) : RecyclerView.Adapter<Adapter_List_Articles.Articles_Holder>() {

    var list_Articles = ArrayList<Artic>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Articles_Holder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_articles, parent,false)
    )



    override fun onBindViewHolder(holder: Adapter_List_Articles.Articles_Holder, position: Int) {

       val articleList = list_Articles[position]
        holder.bind(articleList)

    }

    override fun getItemCount(): Int = list_Articles.size

    /////////////////////////////// Class Articles_Holder  /////////////////////////////////////////////

        inner class Articles_Holder( private val articlesBinding : ArticlesBinding) :RecyclerView.ViewHolder(articlesBinding.root) {
        fun bind(artic:Artic){

            this.articlesBinding.articlesmodel = artic
            articlesBinding.executePendingBindings()
        }

    }

    fun setData(newList: ArrayList<Artic>){
        list_Articles = newList
        notifyDataSetChanged()
    }

}