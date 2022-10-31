# [Toeplitz Matrix](https://leetcode.com/problems/toeplitz-matrix/)

Daily challenge, simple problem.

```java
/**
 * 1 ms, 46.2 MB
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rc = matrix.length;
        int cc = matrix[0].length;
        for (int i = 0; i < cc; i++) {
            int start = matrix[0][i];
            int row = 0;
            int col = i;
            while (true) {
                if (row >= rc || col >= cc) {
                    break;
                }
                if (matrix[row][col] != start) {
                    return false;
                }
                row++;
                col++;
            }
        }
        for (int i = 0; i < rc; i++) {
            int start = matrix[i][0];
            int row = i;
            int col = 0;
            while (true) {
                if (row >= rc || col >= cc) {
                    break;
                }
                if (matrix[row][col] != start) {
                    return false;
                }
                row++;
                col++;
            }
        }
        return true;
    }
}
```

```python
class Solution:
    '''
    122 ms, 13.9 MB
    '''
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        for r in range(row - 1):
            for c in range(1, col):
                if matrix[r][c - 1] != matrix[r + 1][c]:
                    return False
        return True
```
