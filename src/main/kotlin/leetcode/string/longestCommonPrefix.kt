package leetcode.string


private fun main(){
    val strs = arrayOf("flower","flow","flight")
//    println(strs[0])
//    val s1= strs[0].toCharArray()
//    println(s1[0])
//    val s2 = strs[0].toCharArray()
//    println(s2[0])
//    val s3 = strs[0].toCharArray()
//    println(s3[0])
    println(longestCommonPrefix(strs))
    println(longestCommonPrefix1(strs))

}
/* 153ms*/
private fun longestCommonPrefix(strs: Array<String>): String {
    if(strs.isEmpty()) return ""

    var prefix = strs[0]
    for(str in strs){
        while(!str.startsWith(prefix)){
            prefix = prefix.substring(0, prefix.length - 1)
            if(prefix.isEmpty()) return ""
        }
    }
    return prefix
}

/** 125ms */
fun longestCommonPrefix1(strs: Array<String>): String {
    if(strs.size == 0){
        return ""
    }
    var currentPrefix = strs[0]
    for(i in strs.indices){
        currentPrefix = findPrefix(strs[i], currentPrefix)
    }
    return currentPrefix
}

private fun findPrefix(str1 : String, str2 : String):String{
    var p = 0
    while(p < str1.length && p < str2.length){
        if(str1[p] != str2[p]){
            break
        } else {
            p ++
        }
    }
    return str1.substring(0, p)
}