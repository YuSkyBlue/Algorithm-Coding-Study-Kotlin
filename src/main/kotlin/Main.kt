fun main(args : Array<String>) {
    val str = "Hello, World!"
    println(str.length)
    for(item in str){
        println(item)
    }
    val result = str.substring(7, 12)
    println(result) // Outputs: "World"

}