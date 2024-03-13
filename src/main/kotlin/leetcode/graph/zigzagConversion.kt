package leetcode.graph

private fun main(){
    val input = "PAYPALISHIRING"
    val numRows = 3
    println(zigzagConversion1(input, numRows))
}

/** 268 ms */
private fun zigzagConversion(s : String, numRows :Int) : String{
    if (numRows == 1 || numRows >= s.length) {
        return s
    }

    val rows = MutableList(numRows) { StringBuilder() }
    var curRow = 0
    var goingDown = false

    for (c in s) {
        rows[curRow].append(c)
        if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown
        curRow += if (goingDown) 1 else -1
    }

    return rows.joinToString("") { it.toString() }
}
/** 179 ms */
private fun zigzagConversion1(s :String , numRows: Int) : String{
    val stringBuilder = StringBuilder()
    if(numRows == 1){
        return s
    } else if(numRows == 2){
        var i = 0
        while(i < s.length){
            stringBuilder.append(s.get(i))
            i += 2
        }
        i = 1
        while(i < s.length){
            stringBuilder.append(s.get(i))
            i+= 2
        }
    } else {

        val initialForFirstRow = 0
        val mult = 2 * numRows - 2

        // val initialForDownward = i // assuming index and not starting from 1 like numRows
        // val initialForUpward = 2 * numRows - 2 - i

        val initialForLastRow = numRows - 1

        for (i in 0..<numRows){
            if(i == 0){
                var charIndex = initialForFirstRow
                while(charIndex < s.length){
                    stringBuilder.append(s[charIndex])
                    charIndex += mult
                }
            } else if (i == numRows - 1){
                var charIndex = initialForLastRow
                while(charIndex < s.length){
                    stringBuilder.append(s[charIndex])
                    charIndex += mult
                }
            } else {
                var charIndexDown = i
                var charIndexUp = 2 * numRows - 2 - i
                while(charIndexDown < s.length){
                    stringBuilder.append(s[charIndexDown])
                    charIndexDown += mult
                    if(charIndexUp < s.length){
                        stringBuilder.append(s[charIndexUp])
                        charIndexUp += mult
                    }
                }
            }
        }
    }
    return stringBuilder.toString()
}