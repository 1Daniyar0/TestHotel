package com.example.testhotel.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testhotel.R

class QualityAdapter(private val listItems: ArrayList<String>): RecyclerView.Adapter<QualityAdapter.ViewHolder>() {
    private var selectedItemPosition: Int = -1
    private var listOfSelectedItems = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.quality_item, parent, false)
        return ViewHolder(view)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val item = listItems[position]
        holder.itemLabel.text = listItems[position]
        holder.itemLabel.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
            if(item in listOfSelectedItems){
                listOfSelectedItems.remove(item)
            }
            else{
                listOfSelectedItems.add(item)
            }
        }

        holder.itemLabel.isSelected = item in listOfSelectedItems

    }
    override fun getItemCount(): Int {
        return listItems.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemLabel: TextView
        init {
            // Define click listener for the ViewHolder's View
            itemLabel = itemView.findViewById(R.id.qualityTv)
        }

    }
}