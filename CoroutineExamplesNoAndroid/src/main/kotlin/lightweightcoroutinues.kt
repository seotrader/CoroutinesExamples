import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    // creates a scope and run it in the blocking way, stop the executing of the code and run your coRoutinues. if its
    // your only thing your program does
    runBlocking {
        repeat(1_000_000) {
            launch {
                print(".")
            }
        }
    }
}