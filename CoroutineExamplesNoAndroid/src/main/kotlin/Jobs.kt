import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    // create a coroutineScope
    runBlocking {
        val job1 = launch {
 //           delay(3000L)
            println("Job1 launched")
            val job2 = launch {
                println("job2 launched")
                delay(3000L)
                println("Job2 finished")
            }
            job2.invokeOnCompletion {
                println("Job2 completed")
            }
            val job3 = launch {
                println("job3 launched")
                delay(3000L)
                println("Job3 finished")
            }
            job3.invokeOnCompletion {
                println("job3 is completed")
            }


        }

        job1.invokeOnCompletion {
            println("Job 1 is completed")
        }

        delay(500L)
        println("Job1 will be cancelled")
        job1.cancel()
    }

}