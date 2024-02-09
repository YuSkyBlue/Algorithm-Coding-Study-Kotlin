package leetcode.string

/**
 * Reference :  https://leetcode.com/problems/reverse-string/
 * LetCode : Reversed String(344)
 */
private fun reverseString(s: CharArray) : Unit{
    println(s.reversed())
}
/** 211 ms */
private fun reversedChar(s: CharArray) : Unit{
    var start = 0
    var end = s.size -1
    while(start < end){
        s[start] = s[end].also { s[end] = s[start] }
//        val temp = s[start];
//        s[start] = s[end]
//        s[end] = temp
        start++
        end--
    }

}
fun main(){
   val  s = charArrayOf('h','e','l','l','o')
//    reverseString(s)
    println(reversedChar(s))
}