# [Word Search II](https://leetcode.com/problems/word-search-ii/)

First, building a trie with the `words`, then using each letter of `board` to do dfs.

## code

```java
/**
 * 426 ms, 44.7 MB
 */
class Solution {
    static class Node {
        String word;
        Node[] children;
        public Node() {
            word = null;
            this.children = new Node[26];
        }
    }

    private int[] dr = { 0, 1, 0, -1 };
    private int[] dc = { 1, 0, -1, 0 };
    private List<String> result = new ArrayList<>();
    private int row, col;

    private void dfs(char[][] board, int r, int c, Node node) {
        char ch = board[r][c];
        if (ch == '.') {
            return;
        }
        int idx = ch - 'a';
        Node child = node.children[idx];
        if (child == null) {
            return;
        }
        if (child.word != null) {
            result.add(child.word);
            child.word = null;
        }
        for (int i = 0; i < 4; i++) {
            int nextr = r + dr[i];
            int nextc = c + dc[i];
            if (nextr >= 0 && nextr < row && nextc >= 0 && nextc < col) {
                board[r][c] = '.';
                dfs(board, nextr, nextc, child);
                board[r][c] = ch;
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            int length = word.length();
            Node cur = root;
            for (int i = 0; i < length; i++) {
                int idx = word.charAt(i) - 'a';
                if (cur.children[idx] == null) {
                    Node node = new Node();
                    cur.children[idx] = node;
                }
                cur = cur.children[idx];
                if (i == length - 1) {
                    cur.word = word;
                }
            }
        }
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }
}
```
