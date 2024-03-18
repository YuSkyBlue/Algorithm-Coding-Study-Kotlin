package leetcode.generic

fun <T> printList(list: List<T>) {
    list.forEach { item ->
        println(item)
    }
}

private fun main() {
    val intList = listOf(1, 2, 3)
    val stringList = listOf("Hello", "World")

    printList(intList)  // Works with List<Int>
    printList(stringList)  // Works with List<String>
}
