package com.example.hilt_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val dataSet: List<Post>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val created_date: TextView = view.findViewById(R.id.created_date)
        val post_message: TextView = view.findViewById(R.id.post_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.created_date.text = dataSet[position].createdDate_formatted
        holder.post_message.text = dataSet[position].postContext
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}