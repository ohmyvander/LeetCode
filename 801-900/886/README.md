# [Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)

First build the undirected graph, then do dfs. If visit `node[i]` in odd depth, then `visited[i] = 1`, else `visited[i] = 2`. When the visited value of node `i` is conflict, then return `false`.

## code

```java
/**
 * 65 ms, 71.7 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;
    private int[] visited;

    private boolean dfs(int cur, int prev, int flag) {
        visited[cur] = flag;
        boolean result = true;
        for (Integer next : graph.get(cur)) {
            if (prev == next) {
                continue;
            }
            if (visited[next] != 0 && visited[next] == flag) {
                return false;
            }
            if (result && visited[next] == 0) {
                result = dfs(next, cur, flag ^ 1);
            }
        }
        return result;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new int[n + 1];
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < dislikes.length; i++) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0 && !dfs(i, -1, 2)) {
                return false;
            }
        }
        return true;
    }
}
```
