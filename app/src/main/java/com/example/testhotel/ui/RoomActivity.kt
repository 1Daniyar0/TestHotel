package com.example.testhotel.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.entity.Room
import com.example.testhotel.Status
import com.example.testhotel.databinding.ActivityRoomBinding
import org.koin.android.viewmodel.ext.android.viewModel

class RoomActivity: AppCompatActivity() {

    private lateinit var roomAdapter: RoomAdapter
    private lateinit var binding: ActivityRoomBinding
    private lateinit var listOfRoom: MutableList<Room>



    companion object {
        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, RoomActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        val view = binding.root
        val hotelViewModel: HotelViewModel by viewModel()
        listOfRoom = mutableListOf()

        hotelViewModel.getRoomsInfo()
        setContentView(view)



        hotelViewModel.getRoomsInfoLiveData.observe(this){
            when(it?.status){
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    it.data.let {
                        if (!it?.rooms.isNullOrEmpty()){
                            listOfRoom.addAll(it!!.rooms)
                            setupRv()
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

        roomAdapter = RoomAdapter(listOfRoom,this) {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }
        val mLayoutManager = GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false)

        binding.roomRv.layoutManager = mLayoutManager
        binding.roomRv.adapter = roomAdapter

    }

}