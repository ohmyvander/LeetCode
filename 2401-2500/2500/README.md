# [Delete Greatest Value in Each Row](https://leetcode.com/problems/delete-greatest-value-in-each-row/)

Simple problem.

## code

```java
/**
 * 11 ms, 47 MB
 */
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            Arrays.sort(grid[i]);
        }
        int result = 0;
        for (int j = col - 1; j >= 0; j--) {
            int temp = 0;
            for (int i = 0; i < row; i++) {
                temp = Math.max(temp, grid[i][j]);
            }
            result += temp;
        }
        return result;
    }
}
```
