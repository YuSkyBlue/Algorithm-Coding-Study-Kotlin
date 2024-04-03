package combination

fun main() {
    val elements = listOf("a", "b", "c")
    val combinations = mutableListOf<List<String>>()
    generateCombinations(elements, mutableListOf(), combinations, 0)

    println("Combinations are:")
    for (combination in combinations) {
        println(combination)
    }
}

fun generateCombinations(elements: List<String>, current: MutableList<String>, combinations: MutableList<List<String>>, index: Int) {
    if (index == elements.size) {
        combinations.add(ArrayList(current))
        return
    }

    // Include the current element
    current.add(elements[index])
    generateCombinations(elements, current, combinations, index + 1)

    // Exclude the current element
    current.removeAt(current.size - 1)
    generateCombinations(elements, current, combinations, index + 1)
}
