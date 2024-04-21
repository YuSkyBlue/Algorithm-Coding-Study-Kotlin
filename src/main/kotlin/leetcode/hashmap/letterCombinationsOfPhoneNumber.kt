package leetcode.hashmap

private fun main(){
    println(letterCombinations("23"))
    println(letterCombinations(""))
    println(letterCombinations("2"))
}
/** 193ms */
private fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val digitToLetters = mapOf(
        '2' to "abc", '3' to "def", '4' to "ghi", '5' to "jkl",
        '6' to "mno", '7' to "pqrs", '8' to "tuv", '9' to "wxyz"
    )

    val results = mutableListOf<String>()
    backtrack("", digits, digitToLetters, 0, results)
    return results
}

fun backtrack(combination: String, nextDigits: String,
              digitToLetters: Map<Char, String>, index: Int,
              results: MutableList<String>) {

    if (index == nextDigits.length) {
        results.add(combination)
        return
    }

    val digit = nextDigits[index]
    val letters = digitToLetters[digit] ?: ""

    for (letter in letters) {
        backtrack(combination + letter, nextDigits, digitToLetters, index + 1, results)
    }
}