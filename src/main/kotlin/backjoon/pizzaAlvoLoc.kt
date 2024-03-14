package backjoon

import java.util.*

private fun main(){
    val scanner = Scanner(System.`in`)

    val ax = scanner.nextInt()
    val ay = scanner.nextInt()
    val bx = scanner.nextInt()
    val by = scanner.nextInt()
    val cx = scanner.nextInt()
    val cy = scanner.nextInt()
    val dx = scanner.nextInt()
    val dy = scanner.nextInt()

    pizzaAlvoLoc(ax, ay, bx, by, cx, cy, dx, dy)
}


fun pizzaAlvoLoc(ax: Int, ay: Int, bx: Int, by: Int, cx: Int, cy: Int, dx: Int, dy: Int) {
    var result = 1

    val a = (bx - ax) * (cy - ay) - (cx - ax) * (by - ay)
    val b = (bx - ax) * (dy - ay) - (dx - ax) * (by - ay)

    if (!(a < 0 && b > 0) && !(a > 0 && b < 0)) {
        result = 0
    }

    val c = (cx - dx) * (ay - dy) - (ax - dx) * (cy - dy)
    val d = (cx - dx) * (by - dy) - (bx - dx) * (cy - dy)

    if (!(c < 0 && d > 0) && !(c > 0 && d < 0)) {
        result = 0
    }

    println(result)
}