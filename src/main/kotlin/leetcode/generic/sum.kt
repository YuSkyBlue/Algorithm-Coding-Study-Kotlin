package leetcode.generic

fun <T : Number> sum(a: T, b: T): T {
    return when(a) {
        is Int -> (a + b.toInt()) as T
        is Double -> (a + b.toDouble()) as T
        else -> throw IllegalArgumentException("Unsupported type")
    }
}

fun main() {
    println(sum(1, 2))  // Outputs 3
    println(sum(1.5, 2.5))  // Outputs 4.0
}
