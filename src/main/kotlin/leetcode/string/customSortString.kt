package leetcode.string

//Print the priority map created from the order string.
//Show the comparison between two characters, including their priorities, during the sorting process.
//Display the sorted characters before they are joined back into a string.
//Print the final result string.
private fun main(){
    val order = "bcafg"
    val s = "abcd"
    customSortString(order,s)
}
fun customSortString(order: String, s: String): String {
    // Create a map to determine the priority of each character based on 'order'
    val priorityMap = order.withIndex().associate { it.value to it.index }
    println("Priority Map: $priorityMap")

    // Convert the input string 's' to a char array and sort it based on the priority map
    val sortedCharArray = s.toCharArray().sortedWith(Comparator { a, b ->
        val aPriority = priorityMap.getOrDefault(a, order.length)
        val bPriority = priorityMap.getOrDefault(b, order.length)
        println("Comparing '$a' with priority $aPriority to '$b' with priority $bPriority")
        aPriority.compareTo(bPriority)
    })

    println("Sorted Characters: $sortedCharArray")

    // Join the sorted characters back into a string
    val result = sortedCharArray.joinToString("")
    println("Result: $result")
    return result
}
//fun customSortString(order: String, s: String): String {
//    // Create a map to determine the priority of each character based on 'order'
//    val priorityMap = order.withIndex().associate { it.value to it.index }
//    println("Priority Map: $priorityMap")
//
//    return s.toCharArray().sortedWith(Comparator { a, b ->
//        val aPriority = priorityMap.getOrDefault(a, order.length)
//        val bPriority = priorityMap.getOrDefault(b, order.length)
//        println("Comparing '$a' with priority $aPriority to '$b' with priority $bPriority")
//        aPriority.compareTo(bPriority)
//    }).joinToString("")
//    println("Sorted Characters: $sortedCharArray")
//}

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
