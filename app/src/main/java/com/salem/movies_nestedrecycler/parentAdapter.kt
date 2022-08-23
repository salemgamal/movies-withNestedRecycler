package com.salem.movies_nestedrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.parent_item.view.*

class ParentAdapter(private val context: Context ,private val parentList:ArrayList<Parent>) : RecyclerView.Adapter<ParentAdapter.MyViewHolder>(){
    private lateinit var childAdapter:ChildAdapter

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.parentTitle
        val recV : RecyclerView = itemView.childRec
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val listViewItem = LayoutInflater.from(parent.context).inflate(R.layout.parent_item , parent , false)
        return MyViewHolder(listViewItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = parentList[position].title
        childAdapter = ChildAdapter(parentList[position].movie_list)

        holder.recV.layoutManager = LinearLayoutManager(context ,LinearLayoutManager.HORIZONTAL,false)
        holder.recV.adapter = childAdapter
    }
    override fun getItemCount(): Int {
        return parentList.size
    }
}