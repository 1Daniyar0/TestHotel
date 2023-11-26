package com.example.testhotel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.GetHotelInfoUseCase
import com.example.domain.interactor.GetPaymentDetailsUseCase
import com.example.domain.interactor.GetRoomsInfoUseCase
import com.example.entity.HotelResponse
import com.example.entity.PaymentDetails
import com.example.entity.RoomsResponse
import com.example.testhotel.Resource
import retrofit2.Response

class HotelViewModel(
    private val getHotelInfoUseCase: GetHotelInfoUseCase,
    private val getPaymentDetailsUseCase: GetPaymentDetailsUseCase,
    private val getRoomsInfoUseCase: GetRoomsInfoUseCase
): ViewModel() {
    var getHotelInfoLiveData: MutableLiveData<Resource<HotelResponse>> = MutableLiveData()
    var getPaymentDetailsLivaData: MutableLiveData<Resource<PaymentDetails>> = MutableLiveData()
    var getRoomsInfoLiveData: MutableLiveData<Resource<RoomsResponse>> = MutableLiveData()

    fun getHotelInfo(){
        getHotelInfoLiveData.value = Resource.loading(null)

        getHotelInfoUseCase.execute({
            getHotelInfoLiveData.value = Resource.success(it)

        }, {
            it.printStackTrace()

            getHotelInfoLiveData.value = Resource.error(error = it)
        }, GetHotelInfoUseCase.Params())
    }

    fun getRoomsInfo(){
        getRoomsInfoLiveData.value = Resource.loading(null)

        getRoomsInfoUseCase.execute({
            getRoomsInfoLiveData.value = Resource.success(it)

        },{
            it.printStackTrace()

            getRoomsInfoLiveData.value = Resource.error(error = it)
        }, GetRoomsInfoUseCase.Params())
    }

    fun getPaymentDetails(){
        getPaymentDetailsLivaData.value = Resource.loading(null)

        getPaymentDetailsUseCase.execute({
            getPaymentDetailsLivaData.value = Resource.success(it)

        },{
            it.printStackTrace()

            getPaymentDetailsLivaData.value = Resource.error(error = it)
        }, GetPaymentDetailsUseCase.Params())
    }


}