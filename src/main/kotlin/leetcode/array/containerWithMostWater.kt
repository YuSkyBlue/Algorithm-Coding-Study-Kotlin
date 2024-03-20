package leetcode.array

private fun main(){
    val heights1 = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(maxArea(heights1)) // Output: 49

    val heights2 = intArrayOf(1, 1)
    println(maxArea(heights2)) // Output: 1
}

fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var left = 0
    var right = height.size - 1

    while (left < right) {
        val width = right - left
        val h = minOf(height[left], height[right])
        maxArea = maxOf(maxArea, width * h)

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxArea
}
