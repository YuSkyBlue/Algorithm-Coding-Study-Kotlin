package leetcode.string


private fun main(){
    val order = "bcafg"
    val s = "abcd"
    customSortString(order,s)
}
fun customSortString(order: String, s: String): String {
    val priorityMap = order.withIndex().associate { it.value to it.index }
    return s.toCharArray().sortedWith(Comparator { a, b ->
        val aPriority = priorityMap.getOrDefault(a, order.length)
        val bPriority = priorityMap.getOrDefault(b, order.length)
        aPriority.compareTo(bPriority)
    }).joinToString("")
}

//97
//98
//99
//[a, b, c]

//97
//98
//99
//102
//103
//[a, b, c, f, g]
