package com.scandog

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ScanDogApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}