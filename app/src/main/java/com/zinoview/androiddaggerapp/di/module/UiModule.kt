package com.zinoview.androiddaggerapp.di.module

import com.zinoview.androiddaggerapp.data.cloud.CloudDataSource
import com.zinoview.androiddaggerapp.ui.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UiModule {

    @Provides
    fun provideMainViewModelFactory(cloudDataSource: CloudDataSource) : MainViewModelFactory {
        return MainViewModelFactory.Base(cloudDataSource)
    }

}