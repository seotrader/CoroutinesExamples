import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

/*
Async

Just like launch, except it returns a result in the form of deferred
Deferred - a future promise of value

when we need the value, we call await() blocking call
if he value is available, it will return immediately
if the value isn't it will pause the thread until it is
 */

fun main() {
    runBlocking {
        val firstDeferred = async {
            getFirstValue()
        }
        val secondDeferred = async {
            getSecondValue()
        }
        println("Doing some processing here")
        delay(500L)
        println("waiting for value")
        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()
        println("The result is ${firstValue+secondValue}")
    }
}

suspend fun getFirstValue(): Int {
    delay(1000L)
    val value: Int = Random.nextInt(100)
    println("First value = $value")
    return value
}

suspend fun getSecondValue(): Int {
    delay(1000L)
    val value: Int = Random.nextInt(100)
    println("Second value = $value")
    return value
}