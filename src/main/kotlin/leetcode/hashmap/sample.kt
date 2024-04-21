package leetcode.hashmap

private fun main(){
    val hashMap : HashMap <Int,String> = hashMapOf(1 to "One", 2 to "Two", 3 to "Three")

    hashMap.put(4,"Four")
    hashMap[5] = "Five"
    for( (key, value) in hashMap.entries){
        println("$key = $value")
    }
    val value= hashMap[1]
    println("The value is : $value")

    for(key in hashMap.keys){
        println("$key = ${hashMap[key]}")
    }
    for(value in hashMap.values){
        println("$value")
    }
}