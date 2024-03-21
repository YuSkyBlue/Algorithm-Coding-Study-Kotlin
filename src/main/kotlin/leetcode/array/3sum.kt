package leetcode.array
private fun main(){
    val nums = intArrayOf(-1,0,1,2,-1,-4)
    println( threeSum2(nums))
}

/** Frist Try But Time Limit Exceed*/
fun threeSum1(nums: IntArray): List<List<Int>> {
    nums.sort()
    var answer = mutableSetOf<List<Int>>()

    for(i in 0 until nums.size){
        for(j in i+1 until nums.size){
            for(k in j+1 until nums.size){
                if(nums[i]+ nums[j] + nums[k] == 0){
                    answer.add(listOf(nums[i],nums[j],nums[k]))
                }
            }
        }
    }
    return answer.toList()
}
/** 444ms */
fun threeSum2(nums: IntArray): List<List<Int>> {
    nums.sort() // Sort the array
    val answer = mutableListOf<List<Int>>()

    for (i in nums.indices) {
        // Skip duplicate values
        if (i > 0 && nums[i] == nums[i - 1]) continue

        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]

            when {
                sum == 0 -> {
                    answer.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--

                    // Skip duplicate values for left and right
                    while (left < right && nums[left] == nums[left - 1]) left++
                    while (left < right && nums[right] == nums[right + 1]) right--
                }
                sum < 0 -> left++ // Need a larger sum
                else -> right-- // Need a smaller sum
            }
        }
    }

    return answer
}

/** 462ms*/
fun threeSum3(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    val sorted = nums.copyOf()
    sorted.sort()

    for (i in 0 until sorted.size) {
        if (i == 0 || sorted[i] != sorted[i-1]) {
            findPair(i, sorted, result)
        }
    }

    return result
}

private fun findPair(cur: Int, nums: IntArray, result: MutableList<MutableList<Int>>) {
    val value = nums[cur]
    var left = cur +1
    var right = nums.size - 1

    while (left < right) {
        val sum = nums[cur] + nums[left] + nums[right]

        if (sum > 0) {
            right--
        } else if (sum < 0) {
            left++
        } else {
            result.add(
                mutableListOf(nums[cur],nums[left],nums[right])
            )
            right--
            left++
            while (left < right && nums[left] == nums[left - 1]) {
                left++
            }
        }
    }
}