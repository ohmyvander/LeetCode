# [Minimum Falling Path Sum](https://leetcode.com/problems/minimum-falling-path-sum/)

Solution one, dfs.

Solution two, simple dp. The state transition equation is `dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j]`.

## code

```java
/**
 * Solution one
 * 639 ms, 48.2 MB
 */
class Solution {
    private int[][] min;
    private int result;

    private void dfs(int[][] matrix, int r, int c, int sum) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (min[r][c] <= sum) {
            return;
        }
        min[r][c] = sum;
        if (r == row - 1) {
            result = Math.min(result, sum);
            return;
        }
        for (int dc = -1; dc <= 1; dc++) {
            int nextr = r + 1;
            int nextc = c + dc;
            if (nextr >= 0 && nextr < row && nextc >= 0 && nextc < col) {
                dfs(matrix, nextr, nextc, sum + matrix[nextr][nextc]);
            }
        }
    }

    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        min = new int[row][col];
        result = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j < col; j++) {
            dfs(matrix, 0, j, matrix[0][j]);
        }
        return result;
    }
}
```

```java
/**
 * Solution two
 * 4 ms, 42.7 MB
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int a = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                    int b = dp[i - 1][j];
                    int c = j == col - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                    dp[i][j] = Math.min(Math.min(a, b), c) + matrix[i][j];
                }
                if (i == row - 1) {
                    result = Math.min(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
```
