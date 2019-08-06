package hostev.code.system.coroutine

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers

/**
 * Provides coroutines context for application.
 */
class CoroutineContextProvider {
    val main: CoroutineContext = Dispatchers.Main
    val io: CoroutineContext = Dispatchers.IO
    val default: CoroutineContext = Dispatchers.Default
}
