package com.example.data.remote.impl

import com.example.data.remote.remote.ApiService
import com.example.domain.interactor.GetHotelInfoUseCase
import com.example.domain.interactor.GetPaymentDetailsUseCase
import com.example.domain.interactor.GetRoomsInfoUseCase
import com.example.domain.repository.HotelRepository
import com.example.entity.HotelResponse
import com.example.entity.PaymentDetails
import com.example.entity.RoomsResponse
import io.reactivex.Single

class HotelRepositoryImpl(private val api: ApiService): HotelRepository {
    override fun getHotelInfo(params: GetHotelInfoUseCase.Params): Single<HotelResponse> {
        return api.getHotelInfo().map {
            it.body()
        }
    }

    override fun getRoomsInfo(params: GetRoomsInfoUseCase.Params): Single<RoomsResponse> {
        return api.getRooms().map {
            it.body()
        }
    }

    override fun getPaymentDetails(params: GetPaymentDetailsUseCase.Params): Single<PaymentDetails> {
        return api.getPaymentDetails().map {
            it.body()
        }
    }
}