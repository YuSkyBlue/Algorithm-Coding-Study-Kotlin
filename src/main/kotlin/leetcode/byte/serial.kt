package leetcode.byte

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.experimental.xor

// Mock implementations for missing parts in the provided snippet
const val stx: Byte = 0x02 // Start of text
const val etx: Byte = 0x03 // End of text
val terminalId: String = "Terminal123" // Example terminal ID

// Extension function to convert String to a fixed-length ByteArray
private fun String.toBytes(length: Int): ByteArray {
    val byteArray = this.toByteArray(Charsets.UTF_8)
    return if (byteArray.size >= length) {
        byteArray.copyOfRange(0, length)
    } else {
        ByteArray(length) { if (it < byteArray.size) byteArray[it] else 0 }
    }
}

// Mock logger object
private object logger {
    fun error(msg: String) {
        println(msg) // Simple print for demonstration
    }
}

// XOR function to calculate a checksum or similar
private fun ByteArray.xor(start: Int, end: Int): Byte {
    var result: Byte = 0
    for (index in start until end) {
        result = result xor this[index]
    }
    return result
}

// The function provided in the question
private fun makeHeaderAndTail(jobCode: String, body: ByteArray): ByteArray {
    var packet = byteArrayOf()

    packet += stx
    logger.error("set terminalId: $terminalId")

    packet += terminalId.toBytes(16)
    packet += LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")).toBytes(14)
    packet += jobCode.toBytes(1)
    packet += byteArrayOf(0x00)
    packet += byteArrayOf((body.size and 0x00FF).toByte(), ((body.size and 0xFF00) shr 8).toByte())

    packet += body
    packet += etx
    packet += byteArrayOf(packet.xor(0, packet.size))

    return packet
}
private fun main(){
    val body = "Hello, World!".toByteArray() // Example body
    val jobCode = "A" // Example job code
    val packet = makeHeaderAndTail(jobCode, body)

    println(packet.joinToString(" ") { it.toString(16).padStart(2, '0') }) // Print packet in hex format
}