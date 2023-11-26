package com.example.data.remote.remote

import com.example.entity.HotelResponse
import com.example.entity.PaymentDetails
import com.example.entity.RoomsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v3/d144777c-a67f-4e35-867a-cacc3b827473")
    fun getHotelInfo():Single<Response<HotelResponse>>

    @GET("v3/8b532701-709e-4194-a41c-1a903af00195")
    fun getRooms():Single<Response<RoomsResponse>>

    @GET("/v3/63866c74-d593-432c-af8e-f279d1a8d2ff")
    fun getPaymentDetails():Single<Response<PaymentDetails>>
}