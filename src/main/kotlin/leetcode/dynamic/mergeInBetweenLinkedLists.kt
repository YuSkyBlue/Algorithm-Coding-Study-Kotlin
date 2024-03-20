package leetcode.dynamic

// list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
// Output: [10,1,13,1000000,1000001,1000002,5]
private fun main(){
    val list1Array = arrayListOf(0,1,2,3,4,5,6)
    val a = 2
    val b = 5
    val list2Array = arrayListOf(1000000,1000001,1000002,1000003,1000004)

    val list1 = createListNodeFromArrayList(list1Array)
    val list2 = createListNodeFromArrayList(list2Array)
    val mergedList= mergeInBetween(list1, a, b, list2)
    printList(mergedList)

//    firstTry(list1 , list2, a, b,)
//    println(list1)
}
private fun firstTry(
    list1: MutableList<Int>,
    list2: List<Int>,
    a: Int,
    b: Int
) : List<Int>{
    for(item in a..b){
        list1.remove(item)
    }
    for(item in list2){
        var i = 0
        list1.add(a+i,item)
        i++
    }
    return list1
}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
    var dummy = ListNode(0) // A dummy node to simplify edge cases
    dummy.next = list1

    var preA: ListNode? = dummy // Node before 'a'
    for (i in 0 until a) {
        preA = preA?.next
        println("preA : $preA")
    }

    var postB: ListNode? = preA // Node at 'b'
    for (i in a..b) {
        postB = postB?.next
        println("postB : $postB")
    }

    preA?.next = list2 // Connect preA to start of list2

    var lastOfList2 = list2
    while (lastOfList2?.next != null) { // Find the end of list2
        lastOfList2 = lastOfList2.next
    }

    lastOfList2?.next = postB?.next // Connect end of list2 to postB.next

    return dummy.next // Return the modified list, excluding dummy head
}

fun printList(head: ListNode?) {
    var curr = head
    while (curr != null) {
        print("${curr.`val`} -> ")
        curr = curr.next
    }
    println("null")
}

// Helper function to create a ListNode from an ArrayList
fun createListNodeFromArrayList(arr: ArrayList<Int>): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    for (value in arr) {
        tail.next = ListNode(value)
        tail = tail.next!!
    }
    return dummy.next
}
