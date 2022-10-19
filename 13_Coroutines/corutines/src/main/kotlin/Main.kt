import kotlinx.coroutines.*
import java.math.BigInteger

fun main(): Unit = runBlocking {
    val numberList = listOf(150000, 1000, 5)

    launch {
        for (i in 1..10000) {
            delay(20)
            if (i % 100 == 0) println(".")
            else print(".")
        }
    }
    numberList.forEachIndexed { index, i ->
        launch {
            try {
                println("Process ${(index + 1)} started")
                val result = Fibonacci.take(i)
                println("The $i`th Fibonacci number is ${result}.")
            } catch (_: Throwable) {
                println("The calculation was too long.")
            }
        }
    }
}

object Fibonacci {
    suspend fun take(number: Int): BigInteger {
        return withTimeout(2000L) {
            var fPrevPrev = 0.toBigInteger()
            var fPrev = 1.toBigInteger()
            var fibo = 0.toBigInteger()
            for (i in 3..number) {
                yield()
                fibo = fPrevPrev + fPrev
                fPrevPrev = fPrev
                fPrev = fibo
            }
            fibo
        }
    }
}

