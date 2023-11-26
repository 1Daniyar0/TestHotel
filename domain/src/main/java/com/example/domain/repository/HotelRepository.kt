package com.example.domain.repository

import com.example.domain.interactor.GetHotelInfoUseCase
import com.example.domain.interactor.GetPaymentDetailsUseCase
import com.example.domain.interactor.GetRoomsInfoUseCase
import com.example.entity.HotelResponse
import com.example.entity.PaymentDetails
import com.example.entity.RoomsResponse
import io.reactivex.Single

interface HotelRepository {

    fun getHotelInfo(params: GetHotelInfoUseCase.Params): Single<HotelResponse>

    fun getRoomsInfo(params: GetRoomsInfoUseCase.Params): Single<RoomsResponse>

    fun getPaymentDetails(params: GetPaymentDetailsUseCase.Params): Single<PaymentDetails>
}