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