import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// when a scope create coRoutinues it create context
// scope creates and manage coRoutinues
// Context is the set of variable and data associated with the coRoutine
// Context has Dispatcher and Job
// dispatcher and job

fun main() {
    runBlocking {
        launch(CoroutineName("my name")) {
            println("This is run from ${this.coroutineContext.get(CoroutineName.Key)}")
        }
    }

    // GlobalScope contains inside it as data only the coroutine context
    GlobalScope.launch {

    }
}