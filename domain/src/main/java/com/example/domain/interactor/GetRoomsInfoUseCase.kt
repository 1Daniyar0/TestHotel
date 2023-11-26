package com.example.domain.interactor

import com.example.domain.base.SingleUseCase
import com.example.domain.repository.HotelRepository
import com.example.entity.HotelResponse
import com.example.entity.RoomsResponse
import io.reactivex.Single
import javax.inject.Inject

class GetRoomsInfoUseCase @Inject constructor(private val hotelRepository: HotelRepository) :
    SingleUseCase<RoomsResponse, GetRoomsInfoUseCase.Params>() {

    override fun buildUseCaseSingle(params: Params): Single<RoomsResponse> {
        return hotelRepository.getRoomsInfo(params)
    }

    data class Params(
        val id: String? = null
    )
}