package com.zinoview.androiddaggerapp.di.component

import com.zinoview.androiddaggerapp.MainActivity
import com.zinoview.androiddaggerapp.di.module.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}