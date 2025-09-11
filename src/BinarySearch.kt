//делим множество пополам, сложность O(log n)
//при 100 элементах всего 7 шагов
fun binarySearch(list: List<Int>, item: Int): Int? {
    var startIndex = 0
    var finishIndex = list.size - 1

    while (startIndex <= finishIndex) {
        val midIndex = (finishIndex + startIndex) / 2
        when {
            list[midIndex] == item -> return midIndex
            list[midIndex] > item -> finishIndex = midIndex - 1
            else -> startIndex = midIndex + 1
        }
    }
    return null
}