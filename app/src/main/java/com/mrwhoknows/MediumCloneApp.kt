package com.mrwhoknows

import android.app.Application
import com.mrwhoknows.mediumclone.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MediumCloneApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // timber setup
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}