package com.example.domain.interactor

import com.example.domain.base.SingleUseCase
import com.example.domain.repository.HotelRepository
import com.example.entity.HotelResponse
import io.reactivex.Single
import javax.inject.Inject

class GetHotelInfoUseCase @Inject constructor(private val hotelRepository: HotelRepository) :
    SingleUseCase<HotelResponse, GetHotelInfoUseCase.Params>() {

    override fun buildUseCaseSingle(params: Params): Single<HotelResponse> {
        return hotelRepository.getHotelInfo(params)
    }

    data class Params(
        val id: String? = null
    )
}