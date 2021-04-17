package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.JournalBinding
import com.example.talan_app.view_model.JournalVM


class Adapter_List_Journal(private val context: Context, private val list_journal: ArrayList<JournalVM> ) : RecyclerView.Adapter<Adapter_List_Journal.Journal_Holder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_List_Journal.Journal_Holder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val journalBinding: JournalBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_journal_traveau,parent,false)
        return Journal_Holder(journalBinding)

    }

    override fun onBindViewHolder(holder: Adapter_List_Journal.Journal_Holder, position: Int) {

       val journalList = list_journal[position]
               holder.bind(journalList)

    }

    override fun getItemCount(): Int = list_journal.size

    /////////////////////////////// Class Journal_Holder  /////////////////////////////////////////////
    inner class Journal_Holder(private val journalBinding : JournalBinding): RecyclerView.ViewHolder(journalBinding.root){
        fun bind(journalVM: JournalVM){
            this.journalBinding.journalmodel = journalVM
            journalBinding.executePendingBindings()

        }

    }
}