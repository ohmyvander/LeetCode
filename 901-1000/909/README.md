# [Snakes and Ladders](https://leetcode.com/problems/snakes-and-ladders/)

Not a hard problem, I use dfs to solve. Notice that the array to record the minimum number of moves of each square should be a two-dimensional array, include can jump and cannot jump status.

## code

```java
/**
 * 86 ms, 46.2 MB
 */
class Solution {
    private int[] map;
    private int result = Integer.MAX_VALUE;
    private int[][] visited;

    private void dfs(int curr, boolean canJump, int target, int depth) {
        if (curr == target) {
            result = Math.min(result, depth);
            return;
        }
        int jidx = canJump ? 1 : 0;
        if (depth >= result || depth >= visited[jidx][curr]) {
            return;
        }
        visited[jidx][curr] = depth;
        if (canJump && map[curr] != -1) {
            dfs(map[curr], false, target, depth);
        } else {
            int end = Math.min(curr + 6, target);
            for (int i = curr + 1; i <= end; i++) {
                dfs(i, true, target, depth + 1);
            }
        }
    }

    public int snakesAndLadders(int[][] board) {
        int length = board.length;
        map = new int[length * length + 1];
        visited = new int[2][];
        for (int i = 0; i < 2; i++) {
            visited[i] = new int[length * length + 1];
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        int c = 0;
        int r = length - 1;
        int order = 1;
        int square = 1;
        while (r >= 0) {
            map[square] = board[r][c];
            c += order;
            if (c < 0 || c >= length) {
                r--;
                c -= order;
                order *= -1;
            }
            square++;
        }
        dfs(1, true, length * length, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
```
