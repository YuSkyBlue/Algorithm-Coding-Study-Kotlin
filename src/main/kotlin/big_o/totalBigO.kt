package big_o

private fun main(){
    println("First element: ${findFirstElement(listOf(1, 2, 3, 4, 5))}")

    // O(log n)
    val sortedArray = arrayOf(1, 2, 3, 4, 5)
    println("Binary Search (3 exists?): ${binarySearch(sortedArray, 3)}")

    // O(n)
    val list = listOf(1, 2, 3, 4, 5)
    println("Contains Value (4?): ${containsValue(list, 4)}")

    // O(n log n)
    val unsortedList = listOf(5, 3, 2, 4, 1)
    println("Merge Sort: ${mergeSort(unsortedList)}")

    // O(n^2)
    val arrayForSorting = mutableListOf(5, 4, 3, 2, 1)
    bubbleSort(arrayForSorting)
    println("Bubble Sort: $arrayForSorting")

    // O(2^n)
    val fibNumber = 10
    println("Fibonacci ($fibNumber): ${fibonacci(fibNumber)}")

    // O(n!)
    val listForPermutation = listOf(1, 2, 3)
    println("Permutations of $listForPermutation:")
    permute(listForPermutation, 0, listForPermutation.size - 1)

}
/**   O(1) - Constant Time
 * 입력 크기에 관계없이 완료하는 데 동일한 시간이 걸리는 작업입니다.*/
fun findFirstElement(list: List<Int>): Int? = list.firstOrNull()


/** O(log n) - Logarithmic Time
 * 문제 크기가 각 단계마다 절반으로 줄어드는 작업(이진 검색에서 일반적)
 */
fun binarySearch(array: Array<Int>, target: Int): Boolean {
    var left = 0
    var right = array.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            array[mid] == target -> return true
            array[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return false
}

/**O(n) - Linear Time
 * 입력 크기에 따라 선형적으로 증가하는 연산입니다.
 * */
fun containsValue(list: List<Int>, value: Int): Boolean {
    for (item in list) {
        if (item == value) {
            return true
        }
    }
    return false
}
/** O(n log n) - Linearithmic Time
 * n개 항목을 정렬하기 위한 mergesort 및 Quicksort와 같은 효율적인 정렬 알고리즘에서 일반적입니다.
 * */
fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }
    val middle = list.size / 2
    val left = list.subList(0, middle)
    val right = list.subList(middle, list.size)
    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var i = 0
    var j = 0
    val result = mutableListOf<Int>()
    while (i < left.size && j < right.size) {
        if (left[i] < right[j]) {
            result.add(left[i++])
        } else {
            result.add(right[j++])
        }
    }
    while (i < left.size) result.add(left[i++])
    while (j < right.size) result.add(right[j++])
    return result
}
/** O(n^2) - Quadratic Time
 * 데이터 세트에 대한 중첩된 반복을 포함하는 알고리즘에서 일반적입니다.
 */
fun bubbleSort(array: MutableList<Int>) {
    for (i in 0 until array.size) {
        for (j in 0 until array.size - i - 1) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}
/** O(2^n) - Exponential Time
 * 입력 데이터 세트에 추가할 때마다 런타임이 두 배로 늘어나는 작업입니다.*/
fun fibonacci(n: Int): Int {
    if (n <= 1) {
        return n
    }
    return fibonacci(n - 1) + fibonacci(n - 2)
}
/** O(n!) - Factorial Time
 * 입력 크기에 따라 계승적으로 증가하는 연산으로, 집합의 모든 순열을 생성하는 알고리즘에서 흔히 볼 수 있습니다. */
fun permute(list: List<Int>, l: Int, r: Int) {
    if (l == r) {
        println(list)
    } else {
        for (i in l..r) {
            val swapped = list.toMutableList()
            swapped[l] = list[i].also { swapped[i] = list[l] }
            permute(swapped, l + 1, r)
        }
    }
}
