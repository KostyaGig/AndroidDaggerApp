package com.zinoview.androiddaggerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zinoview.androiddaggerapp.core.App
import com.zinoview.androiddaggerapp.core.ResourceProvider
import javax.inject.Inject

fun Any?.log(message: String) {
    Log.d("zinoviewk",message)
}

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var numbers: Numbers

    @Inject
    lateinit var resourceProvider: ResourceProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).component.inject(this)

        log("Numbers sum ${numbers.sum()}")
        log("App name ${resourceProvider.string(R.string.app_name)}")
    }
}