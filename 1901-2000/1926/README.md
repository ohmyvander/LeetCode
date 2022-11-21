# [Nearest Exit from Entrance in Maze](https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/)

Simple bfs.

## code

```java
/**
 * 6 ms, 43.8 MB
 */
class Solution {
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    private Queue<int[]> queue;

    private int bfs(char[][] maze) {
        int row = maze.length;
        int col = maze[0].length;
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] p = queue.remove();
            if ((p[0] == 0 || p[0] == row - 1 || p[1] == 0 || p[1] == col - 1) && p[2] != 0) {
                result = Math.min(result, p[2]);
            }
            if (p[2] >= result) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextr = p[0] + dr[i];
                int nextc = p[1] + dc[i];
                if (nextr >= 0 && nextr < row && nextc >= 0 && nextc < col && maze[nextr][nextc] != '+') {
                    maze[nextr][nextc] = '+';
                    queue.add(new int[] { nextr, nextc, p[2] + 1 });
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        queue = new LinkedList<>();
        queue.add(new int[] {entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        return bfs(maze);
    }
}
```
