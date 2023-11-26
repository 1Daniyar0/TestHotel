package com.example.testhotel.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.testhotel.R
import net.cachapa.expandablelayout.ExpandableLayout

class TouristAdapter(private val listSize: Int): RecyclerView.Adapter<TouristAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.tourist_item, parent, false)
        return ViewHolder(view)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.touristButton.setOnClickListener {
            if (holder.touristEl.isExpanded) holder.touristEl.collapse()
            else holder.touristEl.expand()
        }

    }
    override fun getItemCount(): Int {
        return listSize
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val touristButton: ImageView = itemView.findViewById(R.id.expandBtn)
        val touristEl = itemView.findViewById<ExpandableLayout>(R.id.touristEl)


    }
}