fun main() {
    var n: Int
    do {
        println("Enter a positive number.")
        n = readLine()?.toIntOrNull() ?: return
        if (n > 0) {
            println("The $n-th fibonacci number is " + fibo(n) + ". It is calculated with loop.")
            println("The $n-th fibonacci number is " + fiboRec(n) + ". It is calculated with recursive function.")
        } else {
            print("Input error. ")
        }
    } while (n <= 0)
}

fun fibo(n: Int): Long {
    var fPrevPrev: Long = 0
    var fPrev: Long = 1
    var f: Long = 0
    for (i in 3..n) {
        f = fPrevPrev + fPrev
        fPrevPrev = fPrev
        fPrev = f
    }
    return f
}

fun fiboRec(n: Int) : Int{
    if (n == 2)
        return 1
    else if (n == 1)
        return 0
    else
        return fiboRec(n - 1) + fiboRec (n - 2)
}