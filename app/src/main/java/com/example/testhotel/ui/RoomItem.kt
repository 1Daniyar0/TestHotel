package com.example.testhotel.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.testhotel.R


class RoomItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var callback: () -> Unit
    init {
        layoutParams = LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        View.inflate(context, R.layout.room_rv_item, this)

        val imageList = ArrayList<SlideModel>()

        val selectRoom = findViewById<TextView>(R.id.selectRoomBtn)
        selectRoom.setOnClickListener {
            callback
        }
        imageList.add(SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years."))
        imageList.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct."))
        imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))

        val imageSlider = findViewById<ImageSlider>(R.id.room_image_slider)
        imageSlider.setImageList(imageList)
    }



    fun setData(feedback: String, position:Int? = null) {

    }

    fun setListeners(callback: () -> Unit){
        this.callback = callback
    }



}