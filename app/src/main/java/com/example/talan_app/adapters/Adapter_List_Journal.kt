package com.example.talan_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.databinding.JournalBinding
import com.example.talan_app.model.Journals




class Adapter_List_Journal(private val context: Context, ) : RecyclerView.Adapter<Adapter_List_Journal.Journal_Holder>()  {

    var list_journal = ArrayList<Journals>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Journal_Holder(
        DataBindingUtil.inflate( LayoutInflater.from(parent.context), R.layout.item_journal_traveau,parent,false))




    override fun onBindViewHolder(holder: Adapter_List_Journal.Journal_Holder, position: Int) {

       val journalList = list_journal[position]
               holder.bind(journalList)

    }

    override fun getItemCount(): Int = list_journal.size

    /////////////////////////////// Class Journal_Holder  /////////////////////////////////////////////
    inner class Journal_Holder(private val journalBinding : JournalBinding): RecyclerView.ViewHolder(journalBinding.root){
        fun bind(worklog: Journals){
            this.journalBinding.journalmodel = worklog
            journalBinding.executePendingBindings()

        }

    }


    fun setData(newList: ArrayList<Journals>){
        list_journal = newList
        notifyDataSetChanged()
    }

}