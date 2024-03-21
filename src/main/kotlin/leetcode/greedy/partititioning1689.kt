package leetcode.greedy

// 232ms
fun minNumbersToFormSum(n: String): Int {
    // The minimum number of same-digital numbers to form 'n' is determined by the largest digit in 'n'.
    return n.maxOf { it - '0' }
}

fun main() {
    val example1 = "32"
    val example2 = "82734"
    val example3 = "27346209830709182346"

    println("Example 1: Input: n = \"$example1\" Output: ${minNumbersToFormSum(example1)}")
    println("Example 2: Input: n = \"$example2\" Output: ${minNumbersToFormSum(example2)}")
    println("Example 3: Input: n = \"$example3\" Output: ${minNumbersToFormSum(example3)}")
}
//: 201ms
fun minPartitions(n: String): Int {
    var max = 0
    for (char in n){
        var i = char.digitToInt()
        if (i > max){
            max = i
        }
    }
    return max
}