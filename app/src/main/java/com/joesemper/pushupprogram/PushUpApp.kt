package com.joesemper.pushupprogram

import android.app.Application
import com.joesemper.pushupprogram.di.databaseModule
import com.joesemper.pushupprogram.di.mainModule
import com.joesemper.pushupprogram.di.repositoryModule
import com.joesemper.pushupprogram.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PushUpApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@PushUpApp)
            modules(
                mainModule,
                databaseModule,
                repositoryModule,
                useCaseModule
            )
        }
    }
}