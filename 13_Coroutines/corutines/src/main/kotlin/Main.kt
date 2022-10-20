import kotlinx.coroutines.*
import java.math.BigInteger

fun main(): Unit = runBlocking {

    val indicatorJob = launch {
        for (i in 1..10000) {
            yield()
            delay(20)
            if (i % 100 == 0) println(".")
            else print(".")
        }
    }
    val fibo1Job = launch {
        val n = 150
        try {
            withTimeout(2000L) {
                println("Process 1 started")
                val result = Fibonacci.take(n)
                println("The $n`th Fibonacci number is ${result}.")
            }
        } catch (_: TimeoutCancellationException) {
            println("The calculation was too long.")
        }
    }

    val fibo2Job = launch {
        val n = 100
        try {
            withTimeout(2000L) {
                println("Process 2 started")
                val result = Fibonacci.take(n)
                println("The $n`th Fibonacci number is ${result}.")
            }
        } catch (_: TimeoutCancellationException) {
            println("The calculation was too long.")
        }
    }

    val fibo3Job = launch {
        val n = 5
        try {
            withTimeout(2000L) {
                println("Process 3 started")
                val result = Fibonacci.take(n)
                println("The $n`th Fibonacci number is ${result}.")
            }
        } catch (_: TimeoutCancellationException) {
            println("The calculation was too long.")
        }
    }
    while (indicatorJob.isActive) {
        delay(10)
        if (fibo1Job.isCompleted && fibo2Job.isCompleted && fibo3Job.isCompleted) indicatorJob.cancel()
    }

}


object Fibonacci {
    suspend fun take(number: Int): BigInteger {
        var fPrevPrev = 0.toBigInteger()
        var fPrev = 1.toBigInteger()
        var fibo = 0.toBigInteger()
        for (i in 3..number) {
            delay(1)
            fibo = fPrevPrev + fPrev
            fPrevPrev = fPrev
            fPrev = fibo
        }
        return fibo
    }
}


