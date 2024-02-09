package leetcode.string


private fun reorderLogFiles(logs: Array<String>): Array<String> {
    // 1. 로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼지치 않는다.
    // 2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
    // 3. 문자가 동일한 경우에는 식별자순으로 한다.
    // 4. 숫자 로그는 입력 순서대로 한다.
    val letterList = mutableListOf<String>()
    val digitList = mutableListOf<String>()

    logs.forEach { log ->
        if(Character.isDigit(log.split(" ")[1][0])){
            digitList.add(log)
        } else {
            letterList.add(log)
        }
    }

    letterList.sortWith(Comparator { s1: String , s2: String ->
        val s1x = s1.split(" ", limit = 2)
        val s2x = s2.split(" ", limit = 2)

        val compared = s1x[1].compareTo(s2x[1])

        if(compared == 0) {
            s1x[0].compareTo(s2x[0])
        } else {
            compared
        }
    })

    letterList.addAll(digitList)
    return letterList.toTypedArray()
}
fun main(){
    val logs = arrayOf(
        "dig1 8 1 5 1",
        "let1 art can",
        "dig2 3 6",
        "let2 own kit dig",
        "let3 art zero"
    )
    reorderLogFiles(logs)
}