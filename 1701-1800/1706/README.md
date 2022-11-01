# [Where Will the Ball Fall](https://leetcode.com/problems/where-will-the-ball-fall/)

Simple problem.

```java
/**
 * 6 ms, 54 MB
 */
class Solution {
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] result = new int[col];
        for (int c = 0; c < col; c++) {
            int curPos = c;
            for (int r = 0; r < row; r++) {
                if ((curPos == 0 && grid[r][curPos] == -1)
                   || (curPos == col - 1 && grid[r][curPos] == 1)
                   || (curPos - 1 >= 0 && grid[r][curPos] == -1 && grid[r][curPos - 1] == 1)
                   || (curPos + 1 < col && grid[r][curPos] == 1 && grid[r][curPos + 1] == -1)) {
                    curPos = -1;
                    break;
                }
                if (grid[r][curPos] == 1) {
                    curPos++;
                } else {
                    curPos--;
                }
            }
            result[c] = curPos;
        }
        return result;
    }
}
```
