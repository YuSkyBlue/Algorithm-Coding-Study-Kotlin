package leetcode.string


/**
 * Reference :  https://leetcode.com/problems/valid-palindrome/
 * LetCode : Valid Palindrome (125)
 */
private fun isAlphanumeric(c: Char): Boolean {
    return c.isLetterOrDigit()
}

/** Speed 180MS */
private fun validPalindrome1(s: String): Boolean {
    // 1.Check Char is Alphabet or Number and return it
    val cleanString = s.filter { isAlphanumeric(it) }.lowercase()
    // 2.reversedString and Check between to string
    val reversedString = cleanString.reversed()
    return cleanString == reversedString
}

/** Speed 233MS */
private fun validPalindrome2(s: String): Boolean {
    // Use regex to filter out non-alphanumeric characters and convert to lowercase
    val cleanString = s.replace(Regex("[^a-zA-Z0-9]"), "").toLowerCase()

    // Check if the cleaned string is a palindrome
    return cleanString == cleanString.reversed()
}

/** Speed 150MS */
private fun bestSpeed(s: String): Boolean {
    var left = 0
    var right = s.length - 1
    while (left < right) {
        while (left < right && !Character.isLetterOrDigit(s[left])) {
            left++
        }
        while (left < right && !Character.isLetterOrDigit(s[right])) {
            right--
        }

        if (Character.toLowerCase(s[left]) != Character.toLowerCase(s[right])) {
            return false
        }
        left++
        right--
    }
    return true
}

fun main() {
    val s1 = "A man, a plan, a canal: Panama"
    val s2 = "race a car"
    val s3 = " "

    println(validPalindrome1(s1))
    println(validPalindrome1(s2))
    println(validPalindrome1(s3))

    println(validPalindrome2(s1))
    println(validPalindrome2(s2))
    println(validPalindrome2(s3))

    println(bestSpeed(s1))
    println(bestSpeed(s2))
    println(bestSpeed(s3))
}
