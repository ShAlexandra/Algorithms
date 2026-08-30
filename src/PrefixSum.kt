/**
 * 303. Range Sum Query - Immutable
 * Given an integer array nums, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 */
class NumArray(nums: IntArray) {
    private val prefix = IntArray(nums.size + 1)

    init {
        for ((i, element) in nums.withIndex()) {
            prefix[i + 1] = prefix[i] + element
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefix[right + 1] - prefix[left]
    }

}

/**
 * 1732. Find the Highest Altitude
 * There is a biker going on a road trip. The road trip consists of n + 1 points at various altitudes. The biker starts his trip on point 0 with altitude equal 0.
 *
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 *
 *
 *
 * Example 1:
 *
 * Input: gain = [-5,1,5,0,-7]
 * Output: 1
 * Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
 * Example 2:
 *
 * Input: gain = [-4,-3,-2,-1,4,3,2]
 * Output: 0
 * Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 */
fun largestAltitude(gain: IntArray): Int {
    var lastHeight = 0
    var max = lastHeight
    for (element in gain) {
        lastHeight += element
        if (lastHeight > max) {
            max = lastHeight
        }
    }
    return max
}

/**
 * 724. Find Pivot Index
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 *
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 */
fun pivotIndex(nums: IntArray): Int {
    val fullSum = nums.sum()
    var leftSum = 0

    for ((i, element) in nums.withIndex()) {
        if (leftSum == fullSum - (leftSum + element)) {
            return i
        }
        leftSum += element
    }
    return -1
}

/**
 * 304. Range Sum Query 2D - Immutable
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Implement the NumMatrix class:
 *
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * You must design an algorithm where sumRegion works on O(1) time complexity.
 */
class NumMatrix(matrix: Array<IntArray>) {

    val prefixMatrix = Array(matrix.size+1){IntArray(matrix[0].size+1)}

    init {
        for (i in 1..matrix.size) {
            for (j in 1..matrix[0].size) {
                prefixMatrix[i][j] = prefixMatrix[i-1][j]+prefixMatrix[i][j-1]-prefixMatrix[i-1][j-1]+matrix[i-1][j-1]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return prefixMatrix[row2+1][col2+1]-prefixMatrix[row2+1][col1]-prefixMatrix[row1][col2+1]+prefixMatrix[row1][col1]
    }

}