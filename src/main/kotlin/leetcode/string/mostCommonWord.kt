package leetcode.string

private fun main(){
//    val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val paragraph = "..Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = arrayOf("hit")
    println(mostCommonWord2(paragraph, banned))
}
/** 248 ms */
fun mostCommandWord1(paragraph : String, banned : Array<String>) : String{
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

/** 202 ms */
fun mostCommonWord2(paragraph: String, banned: Array<String>): String {
    val wordFreq = mutableMapOf<String, Int>()
    var currentWord = StringBuilder()

    for (char in paragraph) {
        if (char.isLetter()) {
            currentWord.append(char)
        } else {
            if (currentWord.isNotEmpty()) {
                val word = currentWord.toString().toLowerCase()
                if (word !in banned && word.isNotBlank()) {
                    wordFreq[word] = wordFreq.getOrDefault(word, 0) + 1
                }
                currentWord.clear()
            }
        }
    }

    if (currentWord.isNotEmpty()) {
        val word = currentWord.toString().toLowerCase()
        if (word !in banned && word.isNotBlank()) {
            wordFreq[word] = wordFreq.getOrDefault(word, 0) + 1
        }
    }

    var mostCommon = ""
    var maxFreq = 0
    for ((word, freq) in wordFreq) {
        if (freq > maxFreq) {
            mostCommon = word
            maxFreq = freq
        }
    }
    return mostCommon
}