package oleynik.andrey.imbdmovies

import android.app.Application
import oleynik.andrey.imbdmovies.di.moviesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        initLogs()
        initDi()
    }


    private fun initLogs() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDi() {
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(listOf(
                moviesModule
            ))
        }
    }
}
