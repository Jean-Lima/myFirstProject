package com.example.aula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_compras.view.*

class SendAdapter(private val list: List<PostModel>) : RecyclerView.Adapter<SendAdapter.ViewHolder>(){

    class   ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.textlist
        val description = itemView.description


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_compras, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = list [position]
        holder.title.text = post.title
        holder.description.text = post.body

    }

}