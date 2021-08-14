/**
 * 9*9 已填充数字的一个数独
 * 判断已填充的数字是否符合要求
 *
 * 暴力枚举
 *
 * 1 ms, 39.1 MB
 */
class Solution {
    private static final char DOT = '.';

    public boolean checkBlock(int row, int column, char[][] board) {
        int[] hash = new int[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                char c = board[i][j];
                if (c == DOT) {
                    continue;
                }
                int idx = c - '0';
                if (hash[idx] != 0) {
                    return false;
                } else {
                    hash[idx] = 1;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] hash = new int[10];
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == DOT) {
                    continue;
                }
                int idx = c - '0';
                if (hash[idx] != 0) {
                    return false;
                } else {
                    hash[idx] = 1;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            int[] hash = new int[10];
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == DOT) {
                    continue;
                }
                int idx = c - '0';
                if (hash[idx] != 0) {
                    return false;
                } else {
                    hash[idx] = 1;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean result = checkBlock(i, j, board);
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }
}
