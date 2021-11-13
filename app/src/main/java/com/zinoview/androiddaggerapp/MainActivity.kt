package com.zinoview.androiddaggerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.zinoview.androiddaggerapp.core.App
import com.zinoview.androiddaggerapp.core.ResourceProvider
import com.zinoview.androiddaggerapp.data.cloud.CloudDataSource
import com.zinoview.androiddaggerapp.ui.MainViewModel
import com.zinoview.androiddaggerapp.ui.MainViewModelFactory
import javax.inject.Inject

fun Any?.log(message: String) {
    Log.d("zinoviewk",message)
}

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var numbers: Numbers

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    val viewModel by viewModels<MainViewModel.Base>() {
        mainViewModelFactory as MainViewModelFactory.Base
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).component.inject(this)

        log("Numbers sum ${numbers.sum()}")
        log("Numbers app name ${numbers.appName()}")

        log("ViewModel ${viewModel.data()}")
    }
}