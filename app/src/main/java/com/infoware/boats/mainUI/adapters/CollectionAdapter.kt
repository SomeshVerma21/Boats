package com.infoware.boats.mainUI.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infoware.boats.R
import com.infoware.boats.Utils.EndPoints
import com.infoware.boats.mainUI.databaseUtils.BoatsEntity
import com.infoware.boats.mainUI.databaseUtils.DatabaseDao

class CollectionAdapter(private val context:Context, var list: MutableList<BoatsEntity>,val dataSource:DatabaseDao) :
    RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>(){
    var listData = mutableListOf<BoatsEntity>()
    init {
        for (i in list)
            listData.add(i)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.collection_list_item,parent,false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.binding(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

     @SuppressLint("NotifyDataSetChanged")
     fun deleteItem(position:Int){
        dataSource.removeFromCollection(list[position].boatId)
        listData.removeAt(position)
        notifyDataSetChanged()
    }

    inner class CollectionViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.idBoatName)
        val price = itemView.findViewById<TextView>(R.id.idBoatPrice)
        val img = itemView.findViewById<ImageView>(R.id.idBoatThumbnail)
        val delete = itemView.findViewById<ImageView>(R.id.idDeleteBoat)
        fun binding(data:BoatsEntity){
            name.text = data.name
            price.text = data.boatPrice.toString()
            Glide.with(img).load(EndPoints.imgBaseUrl+data.imgUrl).into(img)
            delete.setOnClickListener {
                deleteItem(adapterPosition)
            }
        }

    }
}


