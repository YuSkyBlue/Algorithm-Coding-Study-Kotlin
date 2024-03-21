package leetcode.greedy

fun coinChange(coins: IntArray, amount: Int): Int {
    var remaining = amount
    var coinCount = 0

    for (coin in coins) {
        while (remaining - coin >= 0) {
            remaining -= coin
            coinCount++
        }
    }

    // If there's no 1-unit coin, this algorithm might not find a solution.
    // This check ensures that we have indeed formed the exact amount.
    if (remaining > 0) {
        return -1 // indicates no solution
    }

    return coinCount
}

fun main() {
    val coins = intArrayOf(25, 10, 5, 1) // Coin denominations
    val amount = 63 // Amount to make change for

    val result = coinChange(coins, amount)
    if (result != -1) {
        println("Minimum number of coins needed: $result")
    } else {
        println("No solution available with the given coin denominations.")
    }
}