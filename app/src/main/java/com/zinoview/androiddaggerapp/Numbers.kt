package com.zinoview.androiddaggerapp

interface Numbers {

    fun sum() : Int

    class Base(

    ) : Numbers {

        override fun sum(): Int
            = 1
    }
}