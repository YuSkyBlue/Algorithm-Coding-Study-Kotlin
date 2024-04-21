package leetcode.array

private fun main() {
    val list1 = createList(listOf(1, 2, 4))
    val list2 = createList(listOf(1, 3, 4))
    val mergeList = mergeTwoLists(list1, list2)
    printList(mergeList)
}

private fun createList(values: List<Int>): ListNode? {
    val dummy = ListNode(0)
    var current = dummy
    for (value in values) {
        current.next = ListNode(value)
        current = current.next!!
    }
    return dummy.next
}

// Helper function to print linked list
private fun printList(node: ListNode?) {
    var current = node
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    // Initialize a dummy node which acts as the start of the result list
    val dummy = ListNode(0)
    var current = dummy

    // Pointers for list1 and list2
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        if (l1.`val` <= l2.`val`) {
            current.next = l1
            l1 = l1.next
        } else {
            current.next = l2
            l2 = l2.next
        }
        current = current.next!!
    }

    // Attach the remaining elements of l1 or l2
    if (l1 != null) {
        current.next = l1
    } else if (l2 != null) {
        current.next = l2
    }

    return dummy.next // Return the start of the merged list, skipping the dummy node
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}