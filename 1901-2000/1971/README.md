# [Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/)

Simple dfs.

## code

```java
/**
 * 206 ms, 195.1 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;
    private boolean[] visited;

    private boolean dfs(int cur, int destination) {
        boolean result = false;
        if (cur == destination) {
            result = true;
        }
        for (Integer next : graph.get(cur)) {
            if (!result && !visited[next]) {
                visited[next] = true;
                result = dfs(next, destination);
            }
        }
        return result;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new HashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        visited[source] = true;
        return dfs(source, destination);
    }
}
```
