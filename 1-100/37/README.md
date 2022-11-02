# [Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)

Simple dfs.

```java
/**
 * 17 ms, 39.8 MB
 */
class Solution {
    public boolean check(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == ch || board[i][c] == ch) {
                return false;
            }
        }
        int rblock = r / 3 * 3;
        int cblock = c / 3 * 3;
        for (int i = rblock; i < rblock + 3; i++) {
            for (int j = cblock; j < cblock + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean dfs(char[][] board, int r, int c, int deep) {
        if (deep == 0) {
            return true;
        }
        int nextr = 0, nextc = 0;
        boolean found = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.' && !(i == r && j == c)) {
                    nextr = i;
                    nextc = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        for (int n = 1; n<= 9; n++) {
            char ch = (char) (n + '0');
            if (!check(board, r, c, ch)) {
                continue;
            }
            board[r][c] = ch;
            if (dfs(board, nextr, nextc, deep - 1)) {
                return true;
            }
            board[r][c] = '.';
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        int deep = 0;
        int start = 0, end = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    deep++;
                    start = i;
                    end = j;
                }
            }
        }
        dfs(board, start, end, deep);
    }
}
```