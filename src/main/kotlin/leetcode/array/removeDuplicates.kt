package leetcode.array

private fun main(){
    val nums = intArrayOf(1,1,2)
    val nums2 = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println(removeDuplicates1(nums))
    println("--------------------")
    println(removeDuplicates1(nums2))

}
fun removeDuplicates(nums: IntArray): Int {
    val sortedNums = nums.toSet()
    println(sortedNums)
    return sortedNums.size
}

fun removeDuplicates1(nums: IntArray): Int {
    var cnt = if (nums.size > 0) 1 else 0

    for (i in 1 until nums.size) {
        if (nums[i] == nums[i-1]) {
            println(nums[i])
            continue
        }
//        nums[cnt] = nums[i]
        cnt++
    }
    return cnt
}