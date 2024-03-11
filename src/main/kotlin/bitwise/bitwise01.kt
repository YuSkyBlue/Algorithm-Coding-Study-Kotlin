package bitwise

import java.io.BufferedReader
import java.io.StringReader

private fun main() {
    // Sample input simulating a log file content
    val logContent = """
        IP Address Access Time URL Status
        192.168.1.1 12:00 /home 200
        10.0.0.1 12:01 /about 404
        192.168.1.2 12:02 /contact 200
        Error Log Empty Entry
        172.16.0.1 12:03 /home 500
        """.trimIndent()

    val items = mutableListOf<String>()

    val bufferedReader = BufferedReader(StringReader(logContent))
    bufferedReader.forEachLine {
        val splitted = it.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (splitted.size >= 4 && splitted[0] != "IP") {
            items.add(splitted[0])
        }
    }

    // Close the BufferedReader
    bufferedReader.close()

    // Print the extracted IP addresses
    println("Extracted IP Addresses:")
    items.forEach { println(it) }
}
