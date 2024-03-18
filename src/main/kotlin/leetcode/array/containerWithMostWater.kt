package leetcode.array


private fun main() {

    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(maxArea(height))
}
/**360 ms  */
private fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxArea = 0
    while (left < right) {
        println("left : $left")
        println("right : $right")
        val width = right - left
        println("width : $width")
        val currentHeight = Math.min(height[left], height[right])
        println(" currentHeight : $currentHeight")
        val currentArea = width * currentHeight
        println("  currentArea : $currentArea")
        maxArea = Math.max(maxArea, currentArea)

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxArea
}



