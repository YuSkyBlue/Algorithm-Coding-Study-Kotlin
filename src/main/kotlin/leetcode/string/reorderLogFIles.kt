package leetcode.string

/**
 * Reference :  https://leetcode.com/problems/reorder-data-in-log-files/description/
 * LetCode : Reorder Data in Log Files (937)
 */

/** 243ms*/
private fun mergeSort(logs: Array<String>) {
    if(logs.size < 2) return

    val middle = logs.size / 2
    val left = logs.copyOfRange(0, middle)
    val right = logs.copyOfRange(middle, logs.size)
    mergeSort(left)
    mergeSort(right)
    merge(left, right, logs)
}

private fun merge(left: Array<String>, right: Array<String>, logs: Array<String>){
    var i = 0
    var j = 0
    var k = 0

    while(i < left.size && j < right.size){
        val compareResult = compare(left[i], right[j])
        if(compareResult <= 0){
            logs[k] = left[i]
            i++
        }else{
            logs[k] = right[j]
            j++
        }
        k++
    }

    while(i < left.size){
        logs[k] = left[i]
        i++
        k++
    }

    while(j < right.size){
        logs[k] = right[j]
        j++
        k++
    }
}

private fun compare(left: String, right: String): Int {
    val leftArr = left.split(" ", limit = 2)
    val rightArr = right.split(" ", limit = 2)
    val leftIsDigit = leftArr[1][0].isDigit()
    val rightIsDigit = rightArr[1][0].isDigit()

    if(!leftIsDigit && !rightIsDigit){
        val contentCompare = leftArr[1].compareTo(rightArr[1])
        if(contentCompare == 0) return leftArr[0].compareTo(rightArr[0])
        else return contentCompare
    }

    if(!leftIsDigit){
        return -1
    }

    if(!rightIsDigit){
        return 1
    }

    return 0
}
/** 223 ms */
private  fun reorderLogFiles(logs: Array<String>): Array<String> {
    // 1. split " " String each of that
    val letterList = mutableListOf<String>()
    val digitList = mutableListOf<String>()
    // 2. if second split string is number or sring
    for(log in logs){
        if(Character.isDigit(log.split(" ")[1][0])){
            digitList.add(log)
        } else{
            letterList.add(log)
        }
    }
    letterList.sortWith(Comparator {s1: String, s2 :String ->
        val s1x = s1.split(" ", limit = 2)
        val s2x = s2.split(" ", limit = 2)

        val compared = s1x[1].compareTo(s2x[1])

        if(compared ==0){
            s1x[0].compareTo(s2x[0])
        } else{
            compared
        }
    })

    letterList.addAll(digitList)

    return letterList.toTypedArray()
}

fun main() {
    val logs = arrayOf("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero")
    mergeSort(logs)
    println(logs.forEach { print(it)})
    println()
    reorderLogFiles(logs).forEach { print(it) }
}