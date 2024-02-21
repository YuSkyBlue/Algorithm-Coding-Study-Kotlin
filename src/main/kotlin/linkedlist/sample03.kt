package linkedlist

import java.util.concurrent.atomic.AtomicReference

class LockFreeStack<T> {
    private val top = AtomicReference<Node<T>?>(null)

    fun push(value: T) {
        val newNode = Node(value)
        do {
            newNode.next = top.get()
        } while (!top.compareAndSet(newNode.next, newNode))
    }

    fun pop(): T? {
        var oldTop: Node<T>?
        var newTop: Node<T>?
        do {
            oldTop = top.get()
            if (oldTop == null) {
                return null // Stack is empty
            }
            newTop = oldTop.next
        } while (!top.compareAndSet(oldTop, newTop))
        return oldTop?.value
    }

    private class Node<T>(val value: T, @Volatile var next: Node<T>? = null)
}
