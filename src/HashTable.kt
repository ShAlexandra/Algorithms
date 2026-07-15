/**
 *
 * 349. Intersection of Two Arrays
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set = HashSet<Int>()
    val result = HashSet<Int>()

    for (num in nums1) {
        set.add(num)
    }

    for (num in nums2) {
        if (set.remove(num)) {
            result.add(num)
        }
    }

    return result.toIntArray()
}

/**
 *
 * 36. Valid Sudoku
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */

fun isValidSudokuHashSet(board: Array<CharArray>): Boolean {
    for (i in 0..<board.size) {
        val hashRow = hashSetOf<Char>()
        val hashColumn = hashSetOf<Char>()
        for (j in 0..<board.size) {
            if (board[i][j].isDigit() && !hashRow.add(board[i][j])) return false
            if (board[j][i].isDigit() && !hashColumn.add(board[j][i])) return false
            if (i % 3 == 0 && j % 3 == 0) {
                val hashBlock = hashSetOf<Char>()

                for (k in i..<i + 3) {
                    for (h in j..<j + 3) {
                        if (board[k][h].isDigit() && !hashBlock.add(board[k][h])) return false
                    }
                }
            }
        }
    }
    return true
}

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashMap = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val value = hashMap[target - nums[i]]
        if (value != null) return intArrayOf(value, i)
        hashMap[nums[i]] = i
    }
    return intArrayOf()
}

/**
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * Output: true
 *
 * Explanation:
 *
 * The strings s and t can be made identical by:
 *
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * Example 2:
 *
 * Input: s = "f11", t = "b23"
 *
 * Output: false
 *
 * Explanation:
 *
 * The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 *
 * Output: true
 */

fun isIsomorphic(s: String, t: String): Boolean {
    val mapS = mutableMapOf<Char, Int>()
    val mapT = mutableMapOf<Char, Int>()

    for (i in s.indices) {
        if (mapS[s[i]] != mapT[t[i]]) {
            return false
        }
        mapS[s[i]] = i
        mapT[t[i]] = i
    }
    return true
}

/**
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

fun romanToInt(s: String): Int {
    var result = 0
    for (i in 0..<s.length - 1) {
        val current = value(s[i])
        val next = value(s[i + 1])
        if (next > current) {
            result -= current
        } else {
            result += current
        }
    }
    result += value(s.last())
    return result
}

fun value(c: Char) = when (c) {
    'I' -> 1
    'V' -> 5
    'X' -> 10
    'L' -> 50
    'C' -> 100
    'D' -> 500
    'M' -> 1000
    else -> -1
}