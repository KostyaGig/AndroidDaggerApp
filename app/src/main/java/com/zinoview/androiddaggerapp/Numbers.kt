package com.zinoview.androiddaggerapp

import com.zinoview.androiddaggerapp.core.ResourceProvider

interface Numbers {

    fun sum() : Int

    fun appName() : String

    class Base(
        private val resourceProvider: ResourceProvider
    ) : Numbers {

        override fun sum(): Int
            = 1

        override fun appName(): String
            = resourceProvider.string(R.string.app_name)
    }
}