fun main() {


    val sourceString = "F2p)v\"y233{0->c}ttelciFc"
    val mid = sourceString.length / 2
    val substring1 = sourceString.substring(0, mid)
    val substring2 = sourceString.substring(mid)
    var x: Int = 0

    fun shift(str: String, x: Int): String {
        var str = str.map {char -> char + x}.joinToString("")
        return str

    }

    fun modify1(str: String, shift: (String, Int) -> String): String {
        var str = shift(str, 1)
        str = str.replace("5", "s")
        str = str.replace("4", "u")
        str = shift(str, -3)
        str = str.replace("0", "o")
        return str
    }

    fun modify2(str: String, shift: (String, Int) -> String): String{
        var str = str.reversed()
        str = shift(str, -4)
        str = str.replace("_", " ")
        return str
    }

    println(modify1(substring1) + modify2(substring2))


}