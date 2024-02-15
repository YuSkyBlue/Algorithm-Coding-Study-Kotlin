package leetcode.byte

private fun main(){
    val packet = byteArrayOf(0x02,64,64,0x6d,70,61,72,0x6b,30,32,0x6d,0x00,0x00,0x00,0x00,0x00,0x00,32,30,32,34,30,32,31,33,31,34,34,35,33,39,47,0x00,53,0x01,31,30,30,30,30,30,30,30,37,35,30,30,30,30,30,30,30,37,35,30,30,30,30,30,30,30,30,30,30,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20
    )
    sliceByte(packet)
}

private fun sliceByte(packet:ByteArray){
    val stx = packet.sliceArray(0 until 1).toHexString()
    val terminalId = packet.sliceArray(1 until 17).toString(Charsets.UTF_8).trimEnd('\u0000')
    val dateTime = packet.sliceArray(17 until 31).toString(Charsets.UTF_8)
    val jobCode = packet.sliceArray(31 until 32).toHexString()
    val responseCode = packet.sliceArray(32 until 33).toHexString()
    val dataLength = packet.sliceArray(33 until 35).toHexString()
    println(stx)
    println(terminalId)
    println(dateTime)
    println(jobCode)
    println(responseCode)
    println(responseCode)


    /*
    STX (Start of Text): 02
    Terminal ID: ddmpark02m
    Date Time: 20240213144539
    Job Code: G  -> [연동 장치 ► 결제기] 부가정보 추가 거래승인 요청전문
    Response Code: 00
    Data Length: 53 01
     */
}

private fun ByteArray.toHexString() = asUByteArray().joinToString(" ") { it.toString(16).padStart(2, '0') }
