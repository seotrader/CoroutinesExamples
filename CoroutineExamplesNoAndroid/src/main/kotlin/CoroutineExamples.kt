import kotlinx.coroutines.*

fun main() {
    // Scope of the coroutines is the scope of the entire application, usually not used
    GlobalScope.launch {
        task2()
    }

    task1()
    Thread.sleep(3000)
}

fun task1() {
    print("Hello, ")
    print(Thread.currentThread().name)
}

suspend fun task2() {
    withContext(Dispatchers.IO) {
        delay(1000)
        println("World!")
        print(Thread.currentThread().name)
    }
}