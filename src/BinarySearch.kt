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

class Solution1 {
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


/**
 * 278. First Bad Version
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 */


/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

abstract class VersionControl() {
    open fun isBadVersion(version: Int): Boolean = version >= 4
    abstract fun firstBadVersion(n: Int): Int

}

class Solution2 : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var startIndex = 1
        var finishIndex = n

        while (startIndex <= finishIndex) {
            val midIndex = startIndex + (finishIndex - startIndex) / 2


            when (isBadVersion(midIndex)) {
                false -> startIndex = midIndex + 1
                true -> finishIndex = midIndex - 1
            }
        }
        return startIndex
    }
}

/**
 * 441. Arranging Coins
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 *
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 */

class Solution {
    fun arrangeCoins(n: Int): Int {
        var startIndex = 1
        var finishIndex = n
        while (startIndex <= finishIndex) {
            val lastElem = startIndex + (finishIndex - startIndex) / 2
            val sumOfRows = (1 + lastElem).toDouble() * lastElem / 2
            when {
                sumOfRows == n.toDouble() -> return lastElem
                sumOfRows > n -> finishIndex = lastElem - 1
                else -> startIndex = lastElem + 1
            }
        }
        return finishIndex
    }
}
