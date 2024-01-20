package leetcode.string


/**
 * Reference :  https://leetcode.com/problems/valid-palindrome/
 * LetCode : Valid Palindrome (125)
 */
private fun isAlphanumeric(c: Char): Boolean {
    return c.isLetterOrDigit()
}
private fun  validPalindrome1 (s:String) : Boolean{
    // 1.Check Char is Alphabet or Number and return it
    val cleanString = s.filter { isAlphanumeric(it) }.lowercase()
    // 2.reversedString and Check between to string
    val reversedString = cleanString.reversed()
    return cleanString == reversedString
}

private fun validPalindrome2(s: String): Boolean {
    // Use regex to filter out non-alphanumeric characters and convert to lowercase
    val cleanString = s.replace(Regex("[^a-zA-Z0-9]"), "").toLowerCase()

    // Check if the cleaned string is a palindrome
    return cleanString == cleanString.reversed()
}
fun main(){
    val s1 = "A man, a plan, a canal: Panama"
    val s2 = "race a car"
    val s3 = " "

    println(validPalindrome1(s1))
    println(validPalindrome1(s2))
    println(validPalindrome1(s3))
    println(validPalindrome2(s1))
    println(validPalindrome2(s2))
    println(validPalindrome2(s3))
}
