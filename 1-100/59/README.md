# [Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/)

Simple problem.

```java
/**
 * 1 ms, 42.7 MB
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int row = 0, col = 0;
        int[] dr = new int[] {0, 1, 0, -1};
        int[] dc = new int[] {1, 0, -1, 0};
        int dir = 0;
        int dn = 0;
        while (dn < 4) {
            int newr = row + dr[dir];
            int newc = col + dc[dir];
            if (newr >= 0 && newr < n && newc >= 0 && newc < n && result[newr][newc] == 0) {
                result[row][col] = num++;
                row = newr;
                col = newc;
                dn = 0;
            } else {
                dir = (dir + 1) % 4;
                dn++;
            }
        }
        result[row][col] = num;
        return result;
    }
}
```
