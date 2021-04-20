package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.ArticlesBinding
import com.example.talan_app.view_model.ArticlesVM

class Adapter_List_Articles(private val context: Context, private val list_Articles: ArrayList<ArticlesVM>) : RecyclerView.Adapter<Adapter_List_Articles.Articles_Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_Articles.Articles_Holder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val articlesBinding : ArticlesBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_articles, parent,false)
        return Articles_Holder(articlesBinding)

    }

    override fun onBindViewHolder(holder: Adapter_List_Articles.Articles_Holder, position: Int) {

       val articleList = list_Articles[position]
        holder.bind(articleList)

    }

    override fun getItemCount(): Int = list_Articles.size

    /////////////////////////////// Class Articles_Holder  /////////////////////////////////////////////

        inner class Articles_Holder( private val articlesBinding : ArticlesBinding) :RecyclerView.ViewHolder(articlesBinding.root) {
        fun bind(articlesVM:ArticlesVM){

            this.articlesBinding.articlesmodel = articlesVM
            articlesBinding.executePendingBindings()
        }

    }


}