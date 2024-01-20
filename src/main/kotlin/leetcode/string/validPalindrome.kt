package leetcode.string


/**
 * Reference :  https://leetcode.com/problems/valid-palindrome/
 * LetCode : Valid Palindrome (125)
 */
private fun isAlphanumeric(c: Char): Boolean {
    return c.isLetterOrDigit()
}
private fun  validPalindrome (s:String) : Boolean{
    // 1.Check Char is Alphabet or Number and return it
    val cleanString = s.filter { isAlphanumeric(it) }.lowercase()
    // 2.reversedString and Check between to string
    val reversedString = cleanString.reversed()
    return cleanString == reversedString
}

fun main(){
    val s1 = "A man, a plan, a canal: Panama"
    val s2 = "race a car"
    val s3 = " "

    println(validPalindrome(s1))
    println(validPalindrome(s2))
    println(validPalindrome(s3))
}
