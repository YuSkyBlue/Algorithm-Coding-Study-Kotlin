package backjoon.dynami_programming

import java.io.BufferedReader
import java.io.InputStream
import java.io.*


/** 2839번 */
private fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val value = readLine().toInt()
    println(s1(value))
}

private fun s1(value :Int) : Int{
//    N이 5로 나눠질 경우
//    N이 5과 3의 조합으로 나눠 담을 수 있을 경우
//    N이 3으로 나눠질 경우
//    그리고.. 5와 3으로는 나눠지지 않을 경우
    var newValue= value
    if(value % 5 == 0) return value / 5
    // 1. 5나눈 나머지 3으로 안나눠질경우
    // 1. 3
    var p = 0
    while(value >0){
        newValue -= 3
        p += 1
        if (newValue % 5 == 0){
            p += newValue / 5
            return p
        }
        else if( newValue  == 1 || newValue == 2){
            return -1
        }
        else if  (newValue == 0){
            return  p
        }
    }
    return  0
}

private fun s2(value :Int) : Int{
//    N이 5로 나눠질 경우
//    N이 5과 3의 조합으로 나눠 담을 수 있을 경우
//    N이 3으로 나눠질 경우
//    그리고.. 5와 3으로는 나눠지지 않을 경우
    var count= 0
    var newValue= value
    while(true){
        if(newValue%5 == 0){

            return  (count + newValue/5)
        }
        if(newValue<=0){
            return -1
        }
        newValue-= 3
        count ++

    }
}
