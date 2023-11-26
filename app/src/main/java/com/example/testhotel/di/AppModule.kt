package com.example.testhotel.di

import com.example.data.remote.impl.HotelRepositoryImpl
import com.example.domain.interactor.GetHotelInfoUseCase
import com.example.domain.interactor.GetPaymentDetailsUseCase
import com.example.domain.interactor.GetRoomsInfoUseCase
import com.example.domain.repository.HotelRepository
import com.example.testhotel.ui.HotelViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val archModule = module {
    module("repository") {
        factory {
            HotelRepositoryImpl(get()) as HotelRepository
        }
        factory {
            GetHotelInfoUseCase(get())
        }
        factory {
            GetRoomsInfoUseCase(get())
        }
        factory {
            GetPaymentDetailsUseCase(get())
        }
        module("viewModel") {
            viewModel {
                HotelViewModel(get(),get(),get())
            }
        }
    }
}