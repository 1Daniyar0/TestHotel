package com.example.testhotel.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.testhotel.Status
import com.example.testhotel.databinding.ActivityHotelBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {


    private lateinit var qualityAdapter: QualityAdapter
    private lateinit var binding: ActivityHotelBinding
    private lateinit var estimate: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val imageList = ArrayList<SlideModel>()
        val hotelViewModel: HotelViewModel by viewModel()
        estimate = arrayListOf()
        hotelViewModel.getHotelInfo()
        setupRv()

        binding.selectHotelBtn.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }

        hotelViewModel.getHotelInfoLiveData.observe(this){
            when(it?.status){
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    it.data.let { hotelInfo ->
                        binding.hotelName.text = hotelInfo?.name.toString()
                        binding.estimateTv.text = hotelInfo?.rating.toString()
                        binding.estimateTextTv.text = hotelInfo?.rating_name.toString()
                        binding.addressTv.text = hotelInfo?.adress.toString()
                        binding.priceText.text = hotelInfo?.minimal_price.toString() + " Р"
                        binding.priceForIt.text = hotelInfo?.price_for_it.toString()
                        binding.aboutTv.text = hotelInfo?.about_the_hotel?.description.toString()
                        estimate.addAll(hotelInfo?.about_the_hotel!!.peculiarities)
                        val listImageUrl = hotelInfo?.image_urls
                        if(!listImageUrl.isNullOrEmpty())
                        {
                            for(i in listImageUrl!!){
                                imageList.add(SlideModel(i, ScaleTypes.CENTER_CROP))
                            }
                            binding.imageSlider.setImageList(imageList)

                        }


                    }
                }
                Status.ERROR -> {

                }
                else -> {}
            }
        }


}


    private fun setupRv(){
        qualityAdapter = QualityAdapter(estimate)
        val mLayoutManager = FlexboxLayoutManager(this, FlexDirection.ROW)
        mLayoutManager.setJustifyContent(JustifyContent.FLEX_START)
        binding.qualityRv.layoutManager = mLayoutManager
        binding.qualityRv.adapter = qualityAdapter

    }
}