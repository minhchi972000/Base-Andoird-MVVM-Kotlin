package com.minhchi.basemydocument

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


lateinit var app: App

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}