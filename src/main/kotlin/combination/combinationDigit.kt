package combination

fun main() {
    val n = 5
    val k = 3
    val combinations = calculateCombinations(n, k)
    println("C($n, $k) = $combinations")
}

fun calculateCombinations(n: Int, k: Int): Long {
    return factorial(n) / (factorial(k) * factorial(n - k))
}

fun factorial(number: Int): Long {
    var result = 1L
    for (i in 2..number) {
        result *= i
    }
    return result
}
