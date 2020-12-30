import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    // Scope of the coroutines is the scope of the entire application, usually not used
    GlobalScope.launch {
        delay(1000)
        println("World")
    }

    print("Hello, ")
    Thread.sleep(2000)
    println("Program completed")
}