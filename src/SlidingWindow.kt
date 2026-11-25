/**
 *
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 105
 * s consists of English letters, digits, symbols and spaces.
 */
fun lengthOfLongestSubstring(s: String): Int {
    val setOfChars = mutableSetOf<Char>()
    var maxLength = 0
    var start = 0
    var finish = -1

    while(finish<s.length-1) {
        val nextChar = s[finish+1]
        if(setOfChars.contains(nextChar)) {
            setOfChars.remove(s[start])
            start++
        } else {
            setOfChars.add(nextChar)
            finish++
            maxLength = maxOf(maxLength, (finish-start+1))
        }
    }
    return maxLength
}

/**
 * 438. Find All Anagrams in a String
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
class SolutionSlide {
    private val patternMap = mutableMapOf<Char, Int>()
    private val windowMap = mutableMapOf<Char, Int>()
    private val result = mutableListOf<Int>()

    fun findAnagrams(s: String, p: String): List<Int> {
        var start = 0
        var finish = -1

        if(p.length>s.length) return result.toList()

        for(char in p) {
            addToPatternMap(char)
        }

        while(finish<s.length-1) {
            val nextChar = s[finish+1]
            addToWindowMap(nextChar)
            if(finish-start+1<=p.length-1) {
                finish++
                if(finish==p.length-1) {
                    checkEquals(0)
                }
            } else {
                finish++
                removeFromWindowMap(s[start])
                start++
                checkEquals(start)
            }
        }
        return result.toList()
    }

    fun addToWindowMap(char: Char) {
        windowMap[char] = (windowMap[char] ?: 0) + 1
    }

    fun addToPatternMap(char:Char) {
        patternMap[char] = (patternMap[char] ?: 0) + 1
    }

    fun removeFromWindowMap(char: Char) {
        if(windowMap[char]!!>1) {
            windowMap[char] = windowMap[char]!! - 1
        } else {
            windowMap.remove(char)
        }
    }

    fun checkEquals(index: Int) {
        if(patternMap == windowMap) result.add(index)
    }
}