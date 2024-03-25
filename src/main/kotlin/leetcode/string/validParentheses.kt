package leetcode.string

import java.util.*
import kotlin.collections.ArrayDeque

private fun main(){
    val s1 = "()"
    val s2 = "()[]{}"
    val s3 = "(]"
    val s4 = "{[]}"
    val s5 = "([)]"

    println(isValid(s1))
    println(isValid(s2))
    println(isValid(s3))
    println(isValid(s4))
    println(isValid(s5))
    println("-------------------")
    println(isValid1(s1))
    println(isValid1(s2))
    println(isValid1(s3))
    println(isValid1(s4))
    println(isValid1(s5))
}
// first try failed
fun isValid(s: String): Boolean {
    var answer = false
    var sum = 0
    if(s.isEmpty() || s.length <1) return false
    for(i in s){
        when(i){
            '(' ->{
                for(s1 in 0 until s.length){
                    if(s[s1] == ')') {
                        answer = true
                        break
                    }
                }
            }
            '[' ->{
                for(s1 in 0 until s.length){
                    if(s[s1] == ']') {
                        answer = true
                        break
                    }
                }
            }
            '{' ->{
                for(s1 in 0 until s.length){
                    if(s[s1] == '}') {
                        answer = true
                        break
                    }
                }
            }
        }
        ++sum
    }
    return answer
}

/** 171ms */
fun isValid1(s: String): Boolean {
    val stack = ArrayDeque<Char>() // Use a stack to keep track of opening brackets

    // Iterate through each character in the string
    for (char in s) {
        when (char) {
            // If it's an opening bracket, push it onto the stack
            '(', '[', '{' -> stack.addLast(char)
            // If it's a closing bracket, check if it matches the last opening bracket
            ')', ']', '}' -> {
                if (stack.isEmpty()) return false // Stack is empty, no opening bracket for this closing bracket
                val last = stack.removeLast() // Pop the last opening bracket from the stack
                if (!isMatchingPair(last, char)) return false // Check if the brackets match
            }
        }
    }

    return stack.isEmpty() // If the stack is empty, all brackets were properly closed
}
fun isMatchingPair(open: Char, close: Char): Boolean {
    return (open == '(' && close == ')') ||
            (open == '[' && close == ']') ||
            (open == '{' && close == '}')
}

/** 101ms */
fun isValid2(s: String): Boolean {
    val stack = LinkedList<Char>()
    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack.push(char)
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
        }
    }
    return stack.isEmpty()
}