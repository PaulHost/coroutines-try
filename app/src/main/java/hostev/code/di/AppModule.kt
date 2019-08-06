package hostev.code.di

import hostev.code.system.coroutine.CoroutineContextProvider
import org.koin.dsl.module

/**
 * Provides instructions on how to maintain database dependencies.
 * Depends on MapperModule.
 */
val appModule = module {
    single { CoroutineContextProvider() }
}
