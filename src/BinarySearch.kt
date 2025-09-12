import kotlin.properties.Delegates

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


/**
35. Search Insert Position
Easy
Topics
premium lock icon
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 **/

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var startIndex = 0
        var finishIndex = nums.size - 1
        while (startIndex <= finishIndex) {
            val midIndex = (finishIndex + startIndex) / 2
            when {
                nums[midIndex] == target -> return midIndex
                nums[midIndex] < target -> startIndex = midIndex + 1
                else -> finishIndex = midIndex - 1
            }
        }
        return startIndex
    }
}