package leetcode.string

private fun main(){
    println("Enter a String : ")
    while(true){
        val input= readLine() ?: ""

        if (isPalindrome(input))
            println("\"$input\" is a palindrome.")
        else
            println("\"$input\" is not a palindrome.")
    }

}
private fun isPalindrome(input: String): Boolean {
    val cleanedInput = input.filter { it.isLetterOrDigit() }.toLowerCase()
    return cleanedInput == cleanedInput.reversed()
}