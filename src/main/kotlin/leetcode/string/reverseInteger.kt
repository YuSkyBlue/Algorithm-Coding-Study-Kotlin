package leetcode.string

private fun main(){
    val value1 = 123
    println(reverse1(value1))
    println("--------------------------")
    val value2 =-123
    println(reverse1(value2))
    println("--------------------------")
    val value3 = 120
    println(reverse1(value3))
}
/** 154ms */
private fun reverse(x:Int) : Int{
    val isNegative = x<0
    val result = x.toString().removePrefix("-").reversed()
    return try{
        if(isNegative){
            "-$result".toInt()
        } else{
            result.toInt()
        }
    } catch (e: NumberFormatException){
        0
    }
}
/** 123 ms */
private fun reverse1(x: Int): Int {
    var y: Int = Math.abs(x)
    var reverse: Long = 0
    while (y > 0) {
        reverse = reverse * 10 + y%10 // 나머지
        y/=10 //몫
        println("reverse : $reverse")
        println("y : $y")
    }

    if (reverse > Int.MAX_VALUE || -reverse < Int.MIN_VALUE) {
        return 0
    }

    return if (x < 0) -reverse.toInt() else reverse.toInt()
}