package hostev.code

import android.app.Application
import hostev.code.di.appModule
import hostev.code.di.dataBaseModule
import hostev.code.di.networkModule
import hostev.code.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    repositoryModule,
                    dataBaseModule,
                    networkModule
                )
            )
        }
    }
}