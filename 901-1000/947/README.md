# [Most Stones Removed with Same Row or Column](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/)

Simple dfs, find total `m` forest, and the answer is `n - m`.

## code

```java
/**
 * 77 ms, 42.6 MB
 */
class Solution {
    private boolean[] visited;
    private int result;

    private boolean compare(int[] a, int[] b) {
        if (a[0] == b[0] || a[1] == b[1]) {
            return true;
        }
        return false;
    }

    private void dfs(int[][] stones, int[] start) {
        int length = stones.length;
        for (int i = 0; i < length; i++) {
            if (!visited[i] && compare(stones[i], start)) {
                visited[i] = true;
                result++;
                dfs(stones, stones[i]);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int length = stones.length;
        visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(stones, stones[i]);
            }
        }
        return result;
    }
}
```
