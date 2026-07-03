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
        sum+=(mat[i][i]+mat[i][mat.size-1-i])
    }
    if (mat.size%2==1) {
        sum-=mat[(mat.size-1)/2][(mat.size-1)/2]
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
    val resultMatrix = Array(matrix[0].size){ IntArray(matrix.size) }
    for (i in 0..<matrix[0].size) {
        for (j in 0..<matrix.size) {
            resultMatrix[i][j] = matrix[j][i]
        }
    }
    return resultMatrix
}