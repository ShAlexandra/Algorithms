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
            if (i%3==0 && j%3 ==0) {
                val hashBlock = hashSetOf<Char>()

                for (k in i..<i+3) {
                    for (h in j..<j+3) {
                        if (board[k][h].isDigit() && !hashBlock.add(board[k][h])) return false
                    }
                }
            }
        }
    }
    return true
}
