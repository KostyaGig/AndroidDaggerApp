package com.zinoview.androiddaggerapp.di.module

import com.zinoview.androiddaggerapp.data.cloud.CloudDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideClient() : OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()

    }

    @Provides
    fun provideGson() = GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(client: OkHttpClient,gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideCloudDataSource(retrofit: Retrofit) : CloudDataSource {
        return CloudDataSource.Base(
            retrofit
        )
    }

    private companion object {
        private const val BASE_URL = "http://translatorappserver.pythonanywhere.com"
    }
}