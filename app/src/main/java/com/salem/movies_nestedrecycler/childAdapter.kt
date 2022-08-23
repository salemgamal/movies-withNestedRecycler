package com.salem.movies_nestedrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.child_item.view.*

class ChildAdapter(private var childList : ArrayList<Movie>) :RecyclerView.Adapter<ChildAdapter.ChildHolder>(){
    class ChildHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title :TextView = itemView.childTitle
        val img :ImageView = itemView.childImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        val listViewItem = LayoutInflater.from(parent.context).inflate(R.layout.child_item , parent , false)
        return ChildHolder(listViewItem)
        }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
        holder.title.text = childList[position].movie_title
        Glide.with(holder.itemView.context)
            .load(childList[position].img)
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        return childList.size
    }
}