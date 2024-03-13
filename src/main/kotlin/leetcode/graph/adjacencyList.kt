package leetcode.graph

class Graph(val vertices: Int) {
    private val adjacencyList = MutableList(vertices) { mutableListOf<Int>() }

    fun addEdge(v: Int, w: Int) {
        adjacencyList[v].add(w) // Add w to v's list.
        // For undirected leetcode.graph, uncomment the line below
        // adjacencyList[w].add(v) // Add v to w's list.
    }

    fun printGraph() {
        for (i in 0 until vertices) {
            print("Vertex $i:")
            for (j in adjacencyList[i]) {
                print(" -> $j")
            }
            println()
        }
    }
}

fun main() {
    val graph = Graph(5) // Create a leetcode.graph with 5 vertices

    graph.addEdge(0, 1)
    graph.addEdge(0, 4)
    graph.addEdge(1, 2)
    graph.addEdge(1, 3)
    graph.addEdge(1, 4)
    graph.addEdge(2, 3)
    graph.addEdge(3, 4)

    graph.printGraph()
}
