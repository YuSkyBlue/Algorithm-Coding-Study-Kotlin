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

private fun bestSpeedCleanCode(s: String) : Boolean {
    var left = 0
    var right = s.length -1
    while(left < right ){
        when {
            !Character.isLetterOrDigit(s[left]) -> left ++
            !Character.isLetterOrDigit(s[right]) -> right--
            else -> {
                if(Character.toLowerCase(s[left]) != Character.toLowerCase(s[right])) return false
                left++
                right--
            }
        }

    }
    return true
}
private fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
    while (start < end) {
        when {
            // 영숫자인지 판별하고 유효하지 않으면 뒤로 한 칸 이동
            !Character.isLetterOrDigit(s[start]) -> start++
            // 영숫자인지 판별하고 유효하지 않으면 앞으로 한 칸 이동
            !Character.isLetterOrDigit(s[end]) -> end--
            else -> {
                // 이 외에는 유효한 문자이므로 앞뒤 글자를 모두 소문자로 변경하여 비교
                if (Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                    // 하나라도 일치하지 않는다면 팰린드롬이 아니므로 false 리턴
                    return false
                }
                // 앞쪽 문자는 한 칸 뒤로, 뒤쪽 문자는 한 칸 앞으로 이동
                start++
                end--
            }
        }
    }
    // 무사히 종료될 경우 팰린드롬이므로 true 리턴
    return true
}
fun main() {
    val s1 = "A man, a plan, a canal: Panama"
    val s2 = "race a car"
    val s3 = " "

    println(validPalindrome1(s1))
    println(validPalindrome1(s2))
    println(validPalindrome1(s3))
    println("-------------------")
    println(validPalindrome2(s1))
    println(validPalindrome2(s2))
    println(validPalindrome2(s3))
    println("-------------------")
    println(bestSpeed(s1))
    println(bestSpeed(s2))
    println(bestSpeed(s3))
    println("-------------------")
    println(bestSpeedCleanCode(s1))
    println(bestSpeedCleanCode(s2))
    println(bestSpeedCleanCode(s3))
    println("-------------------")
    println(isPalindrome(s1))
    println(isPalindrome(s2))
    println(isPalindrome(s3))
}
