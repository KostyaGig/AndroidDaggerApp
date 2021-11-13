package com.zinoview.androiddaggerapp.di.module

import android.app.Application
import android.content.Context
import com.zinoview.androiddaggerapp.Numbers
import com.zinoview.androiddaggerapp.core.ResourceProvider
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class,UiModule::class])
class AppModule(
    private val application: Application
) {

    @Provides
    fun provideContext() : Context = application

    @Provides
    fun provideNumbers(resourceProvider: ResourceProvider) : Numbers {
        return Numbers.Base(
            resourceProvider
        )
    }

    @Provides
    fun provideResourceProvider(context: Context) : ResourceProvider {
        return ResourceProvider.Base(context)
    }

}