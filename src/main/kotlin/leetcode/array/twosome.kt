package leetcode.array

private fun main() {
//    val array = arrayOf(2,7,11,15).toIntArray()
//    val target = 9

    val array = arrayOf(3,2,4).toIntArray()
    val target = 6
//    twoSum(array, target)
    twoSum1(array,target)
}
/** 240 ms */
private fun twoSum(nums: IntArray, target: Int): IntArray {

    val output = IntArray(2)
    for(i in 0..< nums.size){
        for(j in i+1..<nums.size){
            if(nums[i] + nums[j] == target){
                output[0] = i
                output[1] = j
                print("i:$i ,j : $j:")
            }
        }
    }
    return output
}
/** 187 ms */
private fun twoSum1(nums: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int,Int>()
    for((index, value) in nums.withIndex()){
        val complement = target - value
        if(map.containsKey(complement)){

            return intArrayOf(map[complement]!!, index)
        }
        map[value] = index
    }
    return intArrayOf()
}

