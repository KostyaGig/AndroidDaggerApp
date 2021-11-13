package com.zinoview.androiddaggerapp.core

import android.app.Application
import com.zinoview.androiddaggerapp.di.component.AppComponent
import com.zinoview.androiddaggerapp.di.component.DaggerAppComponent
import com.zinoview.androiddaggerapp.di.module.AppModule

class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}