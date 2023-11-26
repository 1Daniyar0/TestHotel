package com.example.testhotel.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.models.SlideModel
import com.example.testhotel.databinding.ActivityBookingBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class PaymentActivity: AppCompatActivity() {

    private lateinit var touristAdapter: TouristAdapter

    private lateinit var binding: ActivityBookingBinding
    private lateinit var listOfTemplate: MutableList<String>


    companion object {
        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, PaymentActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupRv()

    }

    private fun setupRv(){
        val imageList = ArrayList<SlideModel>()
        touristAdapter = TouristAdapter(3)
        val mLayoutManager = FlexboxLayoutManager(this, FlexDirection.ROW)
        mLayoutManager.setJustifyContent(JustifyContent.FLEX_START)
        binding.touristRv.layoutManager = mLayoutManager
        binding.touristRv.adapter = touristAdapter
        binding.touristRv.setNestedScrollingEnabled(false)

    }

}