package leetcode.array

private fun main(){
    val array = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
//    val array = intArrayOf(0,1,0)
    println(trap(array))
}
private fun trap(height: IntArray): Int {
    var volume = 0
    var left = 0
    var right = height.size - 1
    var leftMax = height[left]
    var rightMax = height[right]
    var count = 0
    // 투 포인터가 서로 겹칠때까지 반복\
    while(left < right){
        println("left : $left , right :$right")
        leftMax = height[left].coerceAtLeast(leftMax)
        rightMax = height[right].coerceAtLeast(rightMax)
        if(leftMax <= rightMax){
            volume += leftMax - height[left]
            left += 1
        } else {
            volume += rightMax - height[right]
            right -= 1
        }
        println("step $count: leftMax : $leftMax, rightMax : $rightMax volume : $volume")
        count++

    }
    return volume
}