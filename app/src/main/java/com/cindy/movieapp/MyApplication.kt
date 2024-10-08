package com.cindy.movieapp

import android.app.Application
import com.cindy.movieapp.core.di.databaseModule
import com.cindy.movieapp.core.di.networkModule
import com.cindy.movieapp.core.di.repositoryModule
import com.cindy.movieapp.di.useCaseModule
import com.cindy.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}