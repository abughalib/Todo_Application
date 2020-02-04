package com.android.todo

import android.app.Application
import timber.log.Timber

class TimberLog: Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())}

    }

}