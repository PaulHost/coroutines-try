package hostev.code.di

import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import hostev.code.data.Repository
import hostev.code.data.Room.AppDataBase
import hostev.code.data.datasource.DataBaseDataSource
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val repositoryModule = module {
    single { Repository() }
}

val dataBaseModule = module {
    factory {
        Room.databaseBuilder(androidContext(), AppDataBase::class.java, "db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { DataBaseDataSource() }
}

val networkModule = module {
    factory { GsonConverterFactory.create(get()) }

    factory { CoroutineCallAdapterFactory() }

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .client(get())
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .build()
    }
}