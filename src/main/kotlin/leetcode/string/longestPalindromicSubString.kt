package leetcode.string

private fun main(){
    val s1 = "babad"
    println("Input: $s1")
    println("Longest Palindrome: ${longestPalindrome(s1)}") // Expected output: "bab" or "aba"
    println("-------")
    val s2 = "cbbd"
    println("Input: $s2")
    println("Longest Palindrome: ${longestPalindrome(s2)}")
}

private fun longestPalindrome(s: String): String {
    if(s.isEmpty()) return ""

    var start = 0
    var end = 0

    for (i in s.indices){
        val len1 =  expandAroundCenter(s, i, i)
        val len2 = expandAroundCenter(s, i, i + 1) // Even length palindrome
        val len = maxOf(len1, len2)
        if (len > end - start) {
            start = i - (len - 1) / 2
            end = i + len / 2
            println("New longest palindrome found: ${s.substring(start, end + 1)}, Length: $len")

        }
    }
    return s.substring(start, end + 1)
}
private fun expandAroundCenter(s:String, left: Int, right :Int) : Int{
    var L = left
    var R = right
    while(L>= 0 && R <s.length && s[L] == s[R]){
        println("Expanding: Center=($L, $R), Characters=(${s[L]}, ${s[R]})")
        L--
        R++
    }
    println("Final Expansion: ($L, $R), Length: ${R - L - 1}")
    return R - L - 1
}