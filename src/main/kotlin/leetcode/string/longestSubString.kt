package leetcode.string

import kotlin.math.max

private fun main(){
    val  s = "abcabcbb"
    val s1 = "pwwkew"
    println(lengthOfLongestSubstring2(s))
}
private fun method1(s:String): Int{
    var result = s.toSet()
    return result.size
}
/** 195ms */
private fun lengthOfLongestSubString(s:String) : Int{
    var start= 0
    var maxLength = 0
    val charMap = mutableMapOf<Char, Int>()

    for(end in s.indices){
        val currentChar = s[end]
        if(charMap.containsKey(currentChar)){
            start = maxOf(start, charMap[currentChar]!! +1)
        }
        charMap [currentChar] = end
        maxLength = maxOf(maxLength , end - start + 1)
    }
    return maxLength
}

/** 141ms */
private fun lengthOfLongestSubstring2(s: String): Int {
    if (s.length == 0) return 0
    val chars = BooleanArray(255) { false }
    var result = 0
    var left = 0
    var right = 0

    while(right < s.length) {
        while (right < s.length && !chars[s[right].toInt()]) {
            chars[s[right].toInt()] = true
            right++
        }
        result = max(right - left, result)
        chars[s[left].toInt()] = false
        left++
    }
    return result
}

