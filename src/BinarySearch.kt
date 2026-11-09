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

/**
 * 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 */
fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var finish = nums.size - 1
    var mid = finish / 2
    while (start <= finish) {
        if (nums[mid] > target) {
            finish = mid - 1
        } else if (nums[mid] < target) {
            start = mid + 1
        } else return mid
        mid = start + (finish - start) / 2
    }
    return -1
}

/**
 * 69. Sqrt(x)
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */
fun mySqrt(x: Int): Int {
    if (x < 2) return x
    var start = 0
    var finish = x / 2
    var mid = finish / 2

    while (start <= finish) {
        val square = mid.toLong() * mid
        if (square > x) {
            finish = mid - 1
        } else if (square < x) {
            start = mid + 1
        } else return mid
        mid = start + (finish - start) / 2
    }
    return finish
}

/**
 * 367. Valid Perfect Square
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 *
 * A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
 *
 * You must not use any built-in library function, such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 */
fun isPerfectSquare(num: Int): Boolean {
    if (num == 1) return true
    var start = 0
    var finish = num / 2
    var mid = finish / 2

    while (start <= finish) {
        val square = mid.toLong() * mid
        if (square > num) {
            finish = mid - 1
        } else if (square < num) {
            start = mid + 1
        } else return true
        mid = start + (finish - start) / 2
    }
    return false
}

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
fun searchRange(nums: IntArray, target: Int): IntArray {
    var start = 0
    var finish = nums.size - 1
    var mid = finish / 2
    while (start <= finish) {
        if (nums[mid] < target) {
            start = mid + 1
        } else if (nums[mid] > target) {
            finish = mid - 1
        } else {
            var leftStart = start
            var leftFinish = mid
            while (leftStart <= leftFinish) {
                val leftMid = leftStart + (leftFinish - leftStart) / 2
                if (nums[leftMid] == target) {
                    leftFinish = leftMid - 1
                } else {
                    leftStart = leftMid + 1
                }
            }

            var rightStart = mid
            var rightFinish = finish
            while (rightStart <= rightFinish) {
                val rightMid = rightStart + (rightFinish - rightStart) / 2
                if (nums[rightMid] == target) {
                    rightStart = rightMid + 1
                } else {
                    rightFinish = rightMid - 1
                }
            }
            return intArrayOf(leftStart, rightFinish)
        }
        mid = start + (finish - start) / 2
    }
    return intArrayOf(-1, -1)
}

/**
 * 74. Search a 2D Matrix
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var startRow = 0
    var finishRow = matrix.size - 1
    while (startRow <= finishRow) {
        val midRow = startRow + (finishRow - startRow) / 2
        if (matrix[midRow][0] < target) {
            startRow = midRow + 1
        } else if (matrix[midRow][0] > target) {
            finishRow = midRow - 1
        } else return true
    }
    if (finishRow < 0) return false
    var start = 0
    var finish = matrix[0].size - 1
    while (start <= finish) {
        val mid = start + (finish - start) / 2
        if (matrix[finishRow][mid] < target) {
            start = mid + 1
        } else if (matrix[finishRow][mid] > target) {
            finish = mid - 1
        } else return true
    }
    return false
}