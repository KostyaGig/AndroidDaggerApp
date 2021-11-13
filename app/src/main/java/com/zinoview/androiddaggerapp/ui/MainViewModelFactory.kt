package com.zinoview.androiddaggerapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zinoview.androiddaggerapp.data.cloud.CloudDataSource

interface MainViewModelFactory {

    class Base(
        private val cloudDataSource: CloudDataSource
    ) : MainViewModelFactory, ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel.Base(cloudDataSource) as T
        }

    }
}