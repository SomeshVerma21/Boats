package com.infoware.boats.mainUI.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infoware.boats.R

class CollectionAdapter(val context:Context) : RecyclerView.Adapter<CollectionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.collection_list_item,parent,false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }
}

class CollectionViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

}
