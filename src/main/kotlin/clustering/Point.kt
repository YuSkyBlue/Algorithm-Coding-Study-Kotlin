package clustering

import kotlin.math.pow
import kotlin.random.Random

// A simple point class to represent data points
data class Point(val x: Double, val y: Double) {
    fun distance(other: Point): Double = kotlin.math.sqrt((x - other.x).pow(2) + (y - other.y).pow(2))
}

// Function to generate random points
fun generateRandomPoints(n: Int): List<Point> =
    List(n) { Point(Random.nextDouble()*10, Random.nextDouble()*10) }

// K-Means Clustering
fun kMeansClustering(points: List<Point>, k: Int, iterations: Int = 10): List<List<Point>> {
    // Randomly initialize centroids
    val centroids = points.shuffled().take(k).toMutableList()
    var clusters = List(k) { mutableListOf<Point>() }

    for (iteration in 1..iterations) {
        // Clear clusters
        clusters = List(k) { mutableListOf<Point>() }

        // Assign points to the nearest centroid
        points.forEach { point ->
            val nearestCentroidIndex = centroids.indices.minByOrNull { centroidIndex ->
                point.distance(centroids[centroidIndex])
            }!!
            clusters[nearestCentroidIndex].add(point)
        }

        // Recalculate centroids
        centroids.clear()
        clusters.forEach { cluster ->
            val newCentroid = Point(
                cluster.map { it.x }.average(),
                cluster.map { it.y }.average()
            )
            centroids.add(newCentroid)
        }
    }

    return clusters
}

fun main() {
    val points = generateRandomPoints(100) // Generate 100 random points
    val k = 3 // Number of clusters
    val clusters = kMeansClustering(points, k)

    // Print cluster centroids
    clusters.forEachIndexed { index, cluster ->
        println("Cluster $index: ${cluster.size} points")
    }
}
