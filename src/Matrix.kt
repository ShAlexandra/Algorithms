/**
 * 1572. Matrix Diagonal Sum
 * Given a square matrix mat, return the sum of the matrix diagonals.
 *
 * Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],
 *               [4,5,6],
 *               [7,8,9]]
 * Output: 25
 * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 * Notice that element mat[1][1] = 5 is counted only once.
 * Example 2:
 *
 * Input: mat = [[1,1,1,1],
 *               [1,1,1,1],
 *               [1,1,1,1],
 *               [1,1,1,1]]
 * Output: 8
 * Example 3:
 *
 * Input: mat = [[5]]
 * Output: 5
 *
 *
 * Constraints:
 *
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 */

fun diagonalSum(mat: Array<IntArray>): Int {
    var sum = 0
    for (i in 0..<mat.size) {
        sum += (mat[i][i] + mat[i][mat.size - 1 - i])
    }
    if (mat.size % 2 == 1) {
        sum -= mat[(mat.size - 1) / 2][(mat.size - 1) / 2]
    }
    return sum
}

/**
 * 867. Transpose Matrix
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given a 2D integer array matrix, return the transpose of matrix.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: matrix = [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 */

fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val resultMatrix = Array(matrix[0].size) { IntArray(matrix.size) }
    for (i in 0..<matrix[0].size) {
        for (j in 0..<matrix.size) {
            resultMatrix[i][j] = matrix[j][i]
        }
    }
    return resultMatrix
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

fun isValidSudoku(board: Array<CharArray>): Boolean {
    for (i in 0..<board.size) {
        for (j in 0..<board[0].size) {
            val current = board[i][j]
            if (current != '.') {
                for (k in j + 1..<board[0].size) {
                    if (current == board[i][k]) {
                        return false
                    }
                }
                for (k in i + 1..<board.size) {
                    if (board[k][j] == current) {
                        return false
                    }
                }

                val startRow: Int = i / 3 * 3
                val startColumn: Int = j / 3 * 3
                for (k in startRow..startRow + 2) {
                    for (h in startColumn..startColumn + 2) {
                        if ((i != k || j != h) && current == board[k][h]) {
                            return false
                        }
                    }
                }
            }
        }
    }
    return true
}

/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */

fun rotate(matrix: Array<IntArray>): Unit {
    for (i in 0..<matrix.size / 2) {
        for (j in i..matrix.size - 2 - i) {
            var firstIndex = i
            var secondIndex = j
            var k = 0
            do {
                val p = matrix[secondIndex][matrix.size - 1 - firstIndex]
                matrix[secondIndex][matrix.size - 1 - firstIndex] =
                    if (firstIndex == i && secondIndex == j) matrix[firstIndex][secondIndex] else k
                k = p
                val c = secondIndex
                secondIndex = matrix.size - 1 - firstIndex
                firstIndex = c
            } while (firstIndex != i || secondIndex != j)
        }
    }
}

/**
 * 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
fun spiralOrderMath(matrix: Array<IntArray>): List<Int> {
    var horizonSize = matrix.size - 1
    var verticalSize = matrix[0].size - 1
    val pMax = (horizonSize + 1) * (verticalSize + 1)
    val result = MutableList(pMax) { 0 }
    var p = 0
    var horizon = 0
    var vertical = 0
    while (p < pMax) {
        while (p < pMax && vertical <= verticalSize - horizon) {
            result[p++] = matrix[horizon][vertical++]
        }
        horizon++
        vertical--

        while (p < pMax && horizon <= horizonSize - (verticalSize - vertical)) {
            result[p++] = matrix[horizon++][vertical]
        }

        vertical--
        horizon--
        while (p < pMax && vertical >= horizonSize - horizon) {
            result[p++] = matrix[horizon][vertical--]
        }

        horizon--
        vertical++
        while (p < pMax && horizon > verticalSize - (verticalSize - vertical)) {
            result[p++] = matrix[horizon--][vertical]
        }

        vertical++
        horizon++
    }
    return result
}

fun spiralOrderPointers(matrix: Array<IntArray>): List<Int> {
    var top = 0
    var bottom = matrix.lastIndex
    var left = 0
    var right = matrix[0].lastIndex
    val pMax = (bottom + 1) * (right + 1)
    val result = MutableList(pMax) { 0 }

    var p = 0
    while (top <= bottom && left <= right) {
        for (i in left..right) {
                result[p++] = matrix[top][i]
        }
        top++
        if (top>bottom) break

        for (i in top..bottom) {
                result[p++] = matrix[i][right]
        }
        right--
        if (left>right) break

        for (i in right downTo left) {
                result[p++] = matrix[bottom][i]
        }
        bottom--
        if (top>bottom) break

        for (i in bottom downTo top) {
                result[p++] = matrix[i][left]
        }
        left++
    }
    return result
}