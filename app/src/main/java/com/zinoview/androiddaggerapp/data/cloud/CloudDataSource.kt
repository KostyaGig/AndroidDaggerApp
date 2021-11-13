package com.zinoview.androiddaggerapp.data.cloud

import retrofit2.Retrofit

interface CloudDataSource {

    fun data() : String

    class Base(
        private val retrofit: Retrofit
    ) : CloudDataSource {

        override fun data(): String
            = "Data from cloud data source, retrofit hashcode ${retrofit.hashCode()}"
    }
}