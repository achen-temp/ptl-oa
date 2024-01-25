
fun solve (n: Int): ArrayList<Int> {
    val l = mutableListOf<Int>()
    var tempNumber = n
    while (tempNumber != 0) {
        l.add(tempNumber % 10)
        tempNumber /= 10
    }
    l.reverse()

    val result = ArrayList<Int>()
    while (true) {
        var stop = true
        var curr = 0
        for (i in l.indices) {
            curr *= 10
            if (l[i] != 0) {
                curr++
                l[i] = l[i] - 1
                stop = false
            }
        }
        if (stop) {
            break
        }
        result.add(curr)
    }

    result.sort()
    return result
}
