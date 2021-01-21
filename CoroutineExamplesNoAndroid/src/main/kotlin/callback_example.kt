import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import java.lang.Thread.sleep
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface ApiResult {
    fun success(res: String)
    fun error(e: String)
}

fun main() {
    val job = runBlocking {

        var arrayList = arrayListOf<String>()
        launch(Dispatchers.IO) {
            getResult().collect {
                arrayList.add(it)
                withContext(Dispatchers.Default) {
                    println("Got Value = ${Thread.currentThread()}")
                    println("Got value from ioThread. value=$it")
                }
            }
        }

    }
}



fun getResult(): Flow<String> = flow {
    for (i in 0..10) {
        sleep(500L)
        emit(i.toString())
    }
}

fun getData(result: ApiResult) {
    Thread.sleep(1000L)
    result.success("OK1")
    result.error("ERROR")
}

suspend fun getCallBack(): String {
    return suspendCoroutine {cont->
        getData(object: ApiResult {
            override fun success(res: String) {
                cont.resumeWith(Result.success(res))
            }

            override fun error(s: String) {
                cont.resumeWithException(Exception(s))
            }
        })

    }
}