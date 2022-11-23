# [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)

Simple problem.

```java
/**
 * 6 ms, 46.8 MB
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][][] map = new int[3][9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char rowCh = board[i][j];
                if (Character.isDigit(rowCh)) {
                    int idx = rowCh - '1';
                    map[0][i][idx]++;
                    if (map[0][i][idx] >= 2) {
                        return false;
                    }
                }
                char colCh = board[j][i];
                if (Character.isDigit(colCh)) {
                    int idx = colCh - '1';
                    map[1][i][idx]++;
                    if (map[1][i][idx] >= 2) {
                        return false;
                    }
                }
            }
        }
        for (int m = 0; m < 9; m += 3) {
            for (int n = 0; n < 9; n += 3) {
                for (int i = m; i < m + 3; i++) {
                    for (int j = n; j < n + 3; j++) {
                        char cellCh = board[i][j];
                        if (Character.isDigit(cellCh)) {
                            int idx = cellCh - '1';
                            int cell = m + n / 3;
                            map[2][cell][idx]++;
                            if (map[2][cell][idx] >= 2) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
```
