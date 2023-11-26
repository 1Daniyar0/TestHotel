package com.example.testhotel.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.entity.Room
import com.example.testhotel.R
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class RoomAdapter(private val listRooms: MutableList<Room>, private val context: Context, private val callback: ()-> Unit): RecyclerView.Adapter<RoomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.room_rv_item, parent, false)
        return ViewHolder(view)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.roomButton.setOnClickListener {
            callback.invoke()
        }
        val item = listRooms[position]
        val listSlideModel = arrayListOf<SlideModel>()
        for(i in item.image_urls){
            listSlideModel.add(SlideModel(i, ScaleTypes.CENTER_CROP))
        }
        holder.imageSlider.setImageList(listSlideModel)
        val listOfPeculiarities = arrayListOf<String>()
        listOfPeculiarities.addAll(item.peculiarities)
        val qualityAdapter = QualityAdapter(listOfPeculiarities)
        val mLayoutManager = FlexboxLayoutManager(context, FlexDirection.ROW)
        mLayoutManager.setJustifyContent(JustifyContent.FLEX_START)
        holder.peculiaritiesRv.layoutManager = mLayoutManager
        holder.peculiaritiesRv.adapter = qualityAdapter

        holder.roomName.text = item.name
        holder.price.text = item.price + " Р"
        holder.priceForIt.text = item.price_per

    }
    override fun getItemCount(): Int {
        return listRooms.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val roomButton: TextView = itemView.findViewById(R.id.selectRoomBtn)
        val imageSlider = itemView.findViewById<ImageSlider>(R.id.room_image_slider)
        val peculiaritiesRv = itemView.findViewById<RecyclerView>(R.id.peculiaritiesRv)
        val roomName = itemView.findViewById<TextView>(R.id.roomName)
        val price = itemView.findViewById<TextView>(R.id.priceText)
        val priceForIt = itemView.findViewById<TextView>(R.id.priceForIt)

    }
}