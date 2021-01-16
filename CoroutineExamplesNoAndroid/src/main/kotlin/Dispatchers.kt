import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// a dispatcher determines which thread or thread pool the coroutine runs on
// Different dispatchers are available depending on the task specificity
// Launch(Dispatchers.Default)
// Dispatchers:
// Main (UI for Android), needs to be defined in Gradle
// Default: CPU intensive work
// IO: useful for network communication and reading/writing files
// Unconfined: Starts the coroutine in the inherited dispatcher that called it
// newSingleThreadContext("MyThread") - forces creation of new thread

fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("Default Dispatcher. Thread = ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO Dispatcher. Thread = ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined Dispatcher. Thread = ${Thread.currentThread().name}")
            delay(500L)
            println("Unconfined Dispatcher. Thread = ${Thread.currentThread().name}")

        }

    }
}