package leetcode.string

private fun main(){
//    val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val paragraph = "..Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = arrayOf("hit")
    println(mostCommandWord(paragraph, banned))
}
/** 248 ms */
fun mostCommandWord(paragraph : String, banned : Array<String>) : String{
    val words = paragraph.toLowerCase().split(Regex("\\W+")) // [bob, hit, a, ball, the, hit, ball, flew, far, after, it, was, hit,]
//    val words = paragraph.toLowerCase().split(Regex("[^a-zA-Z]+")) // Split on non-alphabetic characters

    val wordFreq = mutableMapOf<String, Int>()

    for(word in words){
        println(word)
        if(word !in banned && word.isNotBlank()){
            wordFreq[word] = wordFreq.getOrDefault(word,0) + 1
        }
    }

    var mostCommon = ""
    var maxFreq = 0
    for((word,freq) in wordFreq){
        if(freq > maxFreq){
            mostCommon = word
            maxFreq = freq
        }
    }
    return mostCommon
}