package com.onigo.onigoapp

import android.app.Application
import com.onigo.onigoapp.di.appDi
import com.onigo.repository.repositoryCoreDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OniGoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@OniGoApplication)
            modules(repositoryCoreDi + appDi)
        }
    }

}