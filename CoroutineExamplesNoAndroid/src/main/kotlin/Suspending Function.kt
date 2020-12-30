import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Suspention functions
// Make callbacks seamless
// Function that can be run in coroutines

// track the number of calls to suspend function
var funCalls = 0

fun main() {

    GlobalScope.launch {
        completeMessage()
    }

    GlobalScope.launch {
        improveMessage()
    }

    print("Hello ")
    Thread.sleep(2000L)
    println("There have been $funCalls calls so far")


}

suspend fun completeMessage() {
    delay(500L)
    println("world")
    funCalls++
}

suspend fun improveMessage() {
    delay(1000L)
    println("Suspend functions are cool")
    funCalls++
}