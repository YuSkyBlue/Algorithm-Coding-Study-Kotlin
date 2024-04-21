package leetcode.array

fun searchInsert1(nums: IntArray, target: Int): Int {
    var sum = 0
    for(i in 0 until nums.size){
        if(nums[i] == target) {
            break
        }
        if(target < nums[i]){
            break
        }
        sum++
    }
    return sum
}
private fun searchInsert2(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] == target) {
            return mid // Target found
        } else if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left // Target not found, return the index where it would be inserted
}