import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import java.lang.Exception

sealed class Result
data class Success(val result: Int): Result()
data class Error(val error: Exception): Result()
object End : Result()

val channel = Channel<Result>()
fun main() {

    val job = runBlocking {

        var arrayList = arrayListOf<String>()
        launch {
            channel.send(Success(1))
            channel.send(Success(2))
            channel.send(Success(2))
            channel.send(Success(4))
            channel.send(Error(Exception("This is an error")))
            channel.send(End)

        }
        launch(Dispatchers.IO) {
            var ret = channel.receive()
            while (ret != End) {
                when (ret) {
                    is Success -> println("Success = ${ret.result}")
                    is Error -> println("Error = ${ret.error.message}")
                }
                ret = channel.receive()
            }
        }

    }
}