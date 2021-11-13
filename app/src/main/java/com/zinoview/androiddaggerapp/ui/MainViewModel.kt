package com.zinoview.androiddaggerapp.ui

import androidx.lifecycle.ViewModel
import com.zinoview.androiddaggerapp.data.cloud.CloudDataSource
import com.zinoview.androiddaggerapp.log

interface MainViewModel {

    fun data() : String

    class Base(
        private val cloudDataSource: CloudDataSource
    ) : MainViewModel, ViewModel() {

        init {
            log("ViewModel init, hashCode - ${hashCode()}")
        }

        override fun data() : String
            = "${cloudDataSource.data()} + from view model"
    }
}