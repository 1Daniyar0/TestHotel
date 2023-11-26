package com.example.domain.interactor

import com.example.domain.base.SingleUseCase
import com.example.domain.repository.HotelRepository
import com.example.entity.PaymentDetails
import com.example.entity.RoomsResponse
import io.reactivex.Single
import javax.inject.Inject

class GetPaymentDetailsUseCase @Inject constructor(private val hotelRepository: HotelRepository) :
    SingleUseCase<PaymentDetails, GetPaymentDetailsUseCase.Params>() {

    override fun buildUseCaseSingle(params: Params): Single<PaymentDetails> {
        return hotelRepository.getPaymentDetails(params)
    }

    data class Params(
        val id: String? = null
    )
}