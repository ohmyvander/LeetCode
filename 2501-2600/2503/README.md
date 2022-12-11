# [Maximum Number of Points From Grid Queries](https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/)

Use a priority queue `queue` to save the border (the grid number is greater equal to current number).

## code

```java
/**
 * 276 ms, 180.2 MB
 */
class Solution {
    private static class Node {
        int r;
        int c;
        int val;
        public Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
        public int getVal() {
            return this.val;
        }
    }

    private boolean[][] visited;
    private Queue<Node> queue;
    private final int[] dr = {0, 1, 0, -1};
    private final int[] dc = {1, 0, -1, 0};

    private int dfs(int[][] grid, int r, int c, int num) {
        if (grid[r][c] >= num) {
            queue.add(new Node(r, c, grid[r][c]));
            return 0;
        }
        visited[r][c] = true;
        int result = 1;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int nextr = r + dr[i];
            int nextc = c + dc[i];
            if (nextr >= 0 && nextr < row && nextc >= 0 && nextc < col && !visited[nextr][nextc]) {
                result += dfs(grid, nextr, nextc, num);
            }
        }
        return result;
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < queries.length; i++) {
            max = Math.max(max, queries[i]);
        }
        int[] map = new int[max + 5];
        visited = new boolean[row][col];
        int num = 1;
        queue = new PriorityQueue<>(Comparator.comparing(Node::getVal));
        Node cur = new Node(0, 0, grid[0][0]);
        while (num <= max + 1) {
            if (map[num] == 0) {
                map[num] = map[num - 1];
            }
            if (cur == null || cur.val >= num) {
                num++;
            } else {
                if (!visited[cur.r][cur.c]) {
                    int temp = dfs(grid, cur.r, cur.c, num);
                    map[num] += temp;
                }
                cur = queue.poll();
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = map[queries[i]];
        }
        return result;
    }
}
```
