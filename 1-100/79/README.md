# [Word Search](https://leetcode.com/problems/word-search/)

dfs or bfs.

## code

```java
/**
 * dfs
 * 146 ms, 41.9 MB
 */
class Solution {
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};

    private boolean dfs(char[][] board, String word, int r, int c, int deep) {
        if (deep == word.length()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nextr = r + dr[i];
            int nextc = c + dc[i];
            if (nextr >= 0 && nextr < row && nextc >= 0 && nextc < col && board[nextr][nextc] == word.charAt(deep)) {
                char ch = board[nextr][nextc];
                board[nextr][nextc] = '.';
                if (dfs(board, word, nextr, nextc, deep + 1)) {
                    return true;
                }
                board[nextr][nextc] = ch;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char ch = board[i][j];
                    board[i][j] = '.';
                    if (dfs(board, word, i, j, 1)) {
                        return true;
                    }
                    board[i][j] = ch;
                }
            }
        }
        return false;
    }
}
```

```java
/**
 * bfs
 * 154 ms, 96.8 MB
 */
class Solution {
    static class Node {
        public int r;
        public int c;
        public int deep;
        public int pathHash;
        Node(int r, int c, int deep, int pathHash) {
            this.r = r;
            this.c = c;
            this.deep = deep;
            this.pathHash = pathHash;
        }
    }
    private static final int[] DIRR = { -1, 1, 0, 0 };
    private static final int[] DIRC = { 0, 0, -1, 1 };
    
    private Queue<Node> queue;

    public boolean bfs(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        Node node;
        while ((node = queue.poll()) != null) {
            int r = node.r;
            int c = node.c;
            int nextDeep = node.deep + 1;
            if (nextDeep == word.length()) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nr = node.r + DIRR[i];
                int nc = node.c + DIRC[i];
                if (nr >= 0 && nr < row && nc >= 0 && nc < column && board[nr][nc] == word.charAt(nextDeep)) {
                    int pathHash = 1 << (nr * column + nc);
                    if ((pathHash & node.pathHash) == 0) {
                        queue.offer(new Node(nr, nc, nextDeep, node.pathHash | pathHash));
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        queue = new ArrayDeque<>();
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    queue.offer(new Node(i, j, 0, 1 << (i * column + j)));
                }
            }
        }
        return bfs(board, word);
    }
}
```