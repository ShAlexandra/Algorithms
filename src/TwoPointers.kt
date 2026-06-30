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
    while (p1 <= p2) {
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

/**
 * 26. Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.
 *
 * The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */

fun removeDuplicatesTwoPointers(nums: IntArray): Int {
    var p1 = 0
    var p2 = 0
    var p = 0

    if (nums.size == 1)
        return 1

    while (p2 < nums.size) {
        if (nums[p1] == nums[p2]) {
            nums[p++] = nums[p1]
            while (p2 < nums.size && nums[p1] == nums[p2]) {
                p2++
            }
            p1 = p2
        }
    }
    return p
}

fun removeDuplicates(nums: IntArray): Int {
    var p = 0

    for (i in 1..<nums.size) {
        if (nums[i] != nums[p]) {
            nums[++p] = nums[i]
        }
    }
    return p + 1
}

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */

fun moveZeroesRwoPointers(nums: IntArray): Unit {
    var p1 = 0
    var p2 = 1

    while (p2 < nums.size) {
        if (nums[p1] == 0) {
            if (nums[p2] == 0) {
                p2++
            } else {
                nums[p1] = nums[p2]
                nums[p2] = 0
                p1++
                p2++
            }
        } else {
            p1++
            p2++
        }
    }
}

fun moveZeroes(nums: IntArray): Unit {
    var insertPos = 0
    for (num in nums) {
        if (num != 0) {
            nums[insertPos++] = num
        }
    }
    while (insertPos < nums.size) {
        nums[insertPos++] = 0
    }
}

/**
 *
 * 167. Two Sum II - Input Array Is Sorted
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * Example 2:
 *
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * Example 3:
 *
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var p1 = 0
    var p2 = numbers.lastIndex
    var sum = numbers[p1] + numbers[p2]
    while (sum != target) {
        if (sum > target) {
            p2--
        } else {
            p1++
        }
        sum = numbers[p1] + numbers[p2]
    }
    return intArrayOf(p1 + 1, p2 + 1)
}


/**
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
fun threeSum(nums: IntArray): List<List<Int>> {

    val listResult = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0..<nums.size - 2) {
        if (i == 0 || nums[i] != nums[i - 1] || nums[i] < 0) {
            var p1 = i + 1
            var p2 = nums.size - 1
            while (p1 < p2) {
                if (nums[p1] + nums[p2] == -nums[i]) {
                    listResult.add(listOf(nums[i], nums[p1], nums[p2]))
                    while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++
                    while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--
                    p1++
                    p2--
                } else {
                    if (nums[p1] + nums[p2] > -nums[i]) {
                        p2--
                    } else
                        p1++
                }
            }
        }
    }
    return listResult
}


/**
 *
 * 443. String Compression
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 *
 * Note: The characters in the array beyond the returned length do not matter and should be ignored.
 *
 *
 *
 * Example 1:
 *
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: 6
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * After modifying the input array in-place, the first 6 characters of chars should be ["a","2","b","2","c","3"].
 * Example 2:
 *
 * Input: chars = ["a"]
 * Output: 1
 * Explanation: The only group is "a", which remains uncompressed since it is a single character.
 * After modifying the input array in-place, the first character of chars should be ["a"].
 * Example 3:
 *
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: 4
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 * After modifying the input array in-place, the first 4 characters of chars should be ["a","b","1","2"].
 *
 *
 * Constraints:
 *
 * 1 <= chars.length <= 2000
 * chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */
fun compressTwoPointers(chars: CharArray): Int {
    var p1 = 0
    var p2 = 0
    var p = 0
    while (p2 < chars.size) {
        if (chars[p1]==chars[p2]) {
            p2++
        } else {
            chars[p++]=chars[p1]
            if (p2-p1>1) {
                val count = (p2-p1).toString()
                for (i in count) {
                    chars[p++] = i
                }
            }
            p1 = p2
        }
    }
    if (p2>p1) {
        chars[p++] = chars[p1]
        if (p2-p1>1) {
            val count = (p2-p1).toString()
            for (i in count) {
                chars[p++] = i
            }
        }
    }
    return p
}

fun compress(chars: CharArray): Int {
    var read = 0
    var write = 0

    while (read<chars.size) {
        val current = chars[read++]
        var count = 1
        while (read<chars.size && chars[read] == current) {
            read++
            count++
        }
        chars[write++] = current
        if (count>1) {
            for (i in count.toString()) {
                chars[write++] = i
            }
        }
    }
    return write
}