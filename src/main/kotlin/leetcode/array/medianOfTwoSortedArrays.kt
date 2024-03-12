package leetcode.array

private fun main(){
    val nums1 = intArrayOf(1,3)
    val nums2= intArrayOf(2)
    println(findMedianSortedArrays1(nums1, nums2))

    val nums3 = intArrayOf(1,2)
    val nums4= intArrayOf(3,4)
    println(findMedianSortedArrays1(nums3, nums4))

    val nums5 = intArrayOf(1,3)
    val nums6= intArrayOf(2,7)
    println(findMedianSortedArrays2(nums5, nums6))

}

/** Fail Case */
private fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
    var result = nums1 + nums2
    result.sort()
    val value = (result[0] + result[result.size- 1]) / 2.0
    return value
}

/** 298 ms */
private fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
    val result = nums1 + nums2
    result.sort()
    val value =  result.size / 2
    return if (result.size % 2 == 0 ){
        (result[value-1] + result[value]) / 2.0
    } else{
        result[value].toDouble()
    }

}