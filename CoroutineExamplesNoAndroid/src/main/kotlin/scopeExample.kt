import kotlinx.coroutines.*

fun main() {
    println("Program execution will now block")
    // Scope creates new scope until all the inner coroutines stops. its ok to block the thead here, no UI, etc.
    runBlocking {
        launch {
            delay(1000L)
            println("Task from runblocking")
        }

        GlobalScope.launch {
            delay(500L)
            println("Task from global scope")
        }

        coroutineScope {
            launch {
                delay(1500L)
                println("Task form coroutineScope")
            }
        }
        println("Program execution will now continue")
    }
}