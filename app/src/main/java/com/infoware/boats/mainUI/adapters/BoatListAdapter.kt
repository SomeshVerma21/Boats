package com.infoware.boats.mainUI.adapters

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infoware.boats.R
import com.infoware.boats.Utils.EndPoints
import com.infoware.boats.mainUI.fragments.BoatDetailsFragment
import com.infoware.boats.mainUI.models.Data

class BoatListAdapter(val context:Context,val list:List<Data>): RecyclerView.Adapter<MViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.boat_card_view,parent,false)
        return MViewHolder(view)
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val activity = context as AppCompatActivity
        holder.bind(list[position],activity)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
    var activity:AppCompatActivity? = null
    val imgView = itemView.findViewById<ImageView>(R.id.idBoatThumbnail)
    val boatTitle = itemView.findViewById<TextView>(R.id.idBoatTitle)
    val boatPrice = itemView.findViewById<TextView>(R.id.idBoatPrice)
    fun bind(data: Data,activity: AppCompatActivity){
        Glide.with(imgView).load(EndPoints.imgBaseUrl+data.cruise_thumb_img).into(imgView)
        boatTitle.text = data.cruise_name
        boatPrice.text = "$"+data.cruise_price.toString()
        this.activity=activity
        itemView.setOnClickListener {
            val fragment = BoatDetailsFragment.newInstance()
            val bundle = Bundle()
            bundle.putString("id",data.id)
            fragment.arguments = bundle
            activity?.supportFragmentManager.beginTransaction()
                .replace(R.id.idMainScreenFragmentContainer,fragment)
                .setReorderingAllowed(true)
                .addToBackStack("next")
                .commit()
        }
    }
}




