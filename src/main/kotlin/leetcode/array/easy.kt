package leetcode.array

// Example usage
private fun main() {
    println(romanToInt("III")) // Output: 3
    println(romanToInt("LVIII")) // Output: 58
    println(romanToInt("MCMXCIV")) // Output: 1994
}


/** 156ms */
//  조건부 확인을 최소화하거나 지도 조회를 줄이거나 불필요한 계산을 피하면 성능이 향상
fun romanToInt1(s: String): Int {
    val n = s.length
    var result: Int = 0
    var previousIndex = 0

    if (n == 1) return s[0].romanToInt()
    else {
        s.forEachIndexed { index, c ->
            val currentInt = c.romanToInt()
            if (index == 0) {
                result += currentInt
            } else {
                val previousInt = s[previousIndex].romanToInt()
                if (currentInt > previousInt) {
                    result += currentInt - 2 * previousInt
                } else {
                    result += currentInt
                }
                previousIndex = index
            }
        }
    }
    return result
}

private fun Char.romanToInt(): Int {
    return when (this) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }
}

/** 331 ms*/
fun romanToInt(s: String): Int {
    val romanMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var result = 0
    var prevValue = 0

    for (char in s) {
        val value = romanMap[char]!!

        // If the previous value is less than the current value,
        // subtract twice the previous value since it was added once before.
        println("prevalue : $prevValue")
        println("value : $value")
        if (prevValue < value) {
            result += value - 2 * prevValue
        } else {
            result += value
        }
        println("result : $result")

        prevValue = value

        println("-----------")
    }

    return result
}
