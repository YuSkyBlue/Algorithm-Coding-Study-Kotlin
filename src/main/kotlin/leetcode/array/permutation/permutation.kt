private fun main() {
    val list = listOf("a", "b", "c")
    permute(list)
}

fun <T> permute(list: List<T>, start: Int = 0) {
    if (start == list.size - 1) {
        println(list)
    } else {
        for (i in start until list.size) {
            val swappedList = list.toMutableList().apply {
                // Swap elements at positions `start` and `i`
                this[start] = this[i].also { this[i] = this[start] }
            }
            permute(swappedList, start + 1)
        }
    }
}