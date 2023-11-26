package com.example.testhotel

import android.app.Application
import android.content.Context
import com.example.testhotel.di.archModule
import com.example.testhotel.di.netModule
import org.koin.android.ext.android.startKoin

open  class App : Application(){




    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(netModule, archModule))

    }

}