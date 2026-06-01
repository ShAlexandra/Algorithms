/**
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 */

fun reverseString(s: CharArray) {
    var p1 = 0
    var p2 = s.size - 1

    while (p1 < p2) {
        val temp = s[p1]
        s[p1] = s[p2]
        s[p2] = temp
        p1++
        p2--
    }
}

/**
 *
 * 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */

fun isPalindrome(s: String): Boolean {
    var p1 = 0
    var p2 = s.length - 1

    while (p1 < p2) {
        when {
            s[p1].isLetterOrDigit() && s[p2].isLetterOrDigit() -> {
                if (s[p1].lowercaseChar() != s[p2].lowercaseChar()) return false

                p1++
                p2--
            }

            !s[p1].isLetterOrDigit() -> p1++
            !s[p2].isLetterOrDigit() -> p2--
        }
    }
    return true
}

/**
 * 88. Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var p1 = m - 1
    var p2 = n - 1
    var p = m + n - 1
    while (p2 >= 0 && p1 >= 0) {
        if (nums1[p1] < nums2[p2]) {
            nums1[p--] = nums2[p2--]
        } else {
            nums1[p--] = nums1[p1--]
        }
    }
    if (p1 < 0) {
        for (i in 0..p2) {
            nums1[i] = nums2[i]
        }
    }
}

fun mergeOn2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var p1 = 0
    var p2 = 0
    var countOfZero = n

    while (countOfZero > 0 && p1 < n + m - countOfZero) {
        when {
            nums1[p1] < nums2[p2] -> p1++

            nums1[p1] >= nums2[p2] -> {
                for (index in (n + m - countOfZero - 1) downTo p1) {
                    nums1[index + 1] = nums1[index]
                }
                countOfZero--
                nums1[p1] = nums2[p2]
                p1++
                p2++
            }
        }
    }
    if (countOfZero > 0) {
        for (index in p1..<m + n) {
            nums1[index] = nums2[p2++]
        }
    }
}

fun sortedSquares(nums: IntArray): IntArray {
    val resArray = IntArray(nums.size)
    var p1 = 0
    var p2 = nums.size - 1
    var p = nums.size - 1
    while (p1<=p2) {
        val leftSquare = nums[p1] * nums[p1]
        val rightSquare = nums[p2] * nums[p2]
        if (leftSquare > rightSquare) {
            resArray[p--] = leftSquare
            p1++
        } else {
            resArray[p--] = rightSquare
            p2--
        }
    }
    return resArray
}