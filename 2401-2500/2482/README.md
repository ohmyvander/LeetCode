# [Difference Between Ones and Zeros in Row and Column](https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/)

Simple problem.

## code

```java
/**
 * 45 ms, 200.4 MB
 */
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] onesRow = new int[row];
        int[] zerosRow = new int[row];
        int[] onesCol = new int[col];
        int[] zerosCol = new int[col];
        for (int i = 0; i < row; i++) {
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    zeros++;
                } else if (grid[i][j] == 1) {
                    ones++;
                }
            }
            onesRow[i] = ones;
            zerosRow[i] = zeros;
        }
        for (int j = 0; j < col; j++) {
            int ones = 0;
            int zeros = 0;
            for (int i = 0; i < row; i++) {
                if (grid[i][j] == 0) {
                    zeros++;
                } else if (grid[i][j] == 1) {
                    ones++;
                }
            }
            onesCol[j] = ones;
            zerosCol[j] = zeros;
        }
        int[][] diff = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        return diff;
    }
}
```
