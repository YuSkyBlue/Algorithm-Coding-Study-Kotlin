package linkedlist

import java.util.concurrent.atomic.AtomicReference

class LockFreeQueue<T> {
    private val head: AtomicReference<Node<T>?> = AtomicReference(null)
    private val tail: AtomicReference<Node<T>?> = AtomicReference(null)

    init {
        // Initialize an empty node
        val dummy = Node<T>(null)
        head.set(dummy)
        tail.set(dummy)
    }

    fun enqueue(value: T) {
        val newNode = Node(value)
        while (true) {
            val currentTail = tail.get()
            val tailNext = currentTail?.next?.get()
            if (currentTail == tail.get()) {
                if (tailNext != null) {
                    // Queue in intermediate state, advance tail
                    tail.compareAndSet(currentTail, tailNext)
                } else {
                    // In stable state, try inserting new node
                    if (currentTail?.next?.compareAndSet(null, newNode) == true) {
                        // Insertion successful, try moving tail to inserted node
                        tail.compareAndSet(currentTail, newNode)
                        return
                    }
                }
            }
        }
    }

    fun dequeue(): T? {
        while (true) {
            val currentHead = head.get()
            val currentTail = tail.get()
            val headNext = currentHead?.next?.get()
            if (currentHead == head.get()) {
                if (currentHead == currentTail) {
                    // Queue is empty or tail falling behind
                    if (headNext == null) {
                        return null // Queue is empty
                    }
                    // Tail is falling behind. Try advancing it
                    tail.compareAndSet(currentTail, headNext)
                } else {
                    // Queue not empty. Try to advance head
                    if (head.compareAndSet(currentHead, headNext)) {
                        return headNext?.value
                    }
                }
            }
        }
    }

    private class Node<T>(val value: T?, val next: AtomicReference<Node<T>?> = AtomicReference(null))
}

fun main() {
    val queue = LockFreeQueue<Int>()

    // Example of enqueueing and dequeueing from multiple threads
    val producer = Thread {
        repeat(10) {
            queue.enqueue(it)
            println("Enqueued: $it")
        }
    }

    val consumer = Thread {
        repeat(10) {
            val value = queue.dequeue()
            println("Dequeued: $value")
        }
    }

    producer.start()
    consumer.start()

    producer.join()
    consumer.join()
}
