# [Minimum Score of a Path Between Two Cities](https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/)

dfs, get the least edge in a tree.

## code

```java
/**
 * 72 ms, 105.5 MB
 */
class Solution {
    private static class Edge {
        int u;
        int v;
        int dist;
        public Edge(int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
    }
    
    private Map<Integer, List<Edge>> graph;
    private boolean[] visited;
    private int result = Integer.MAX_VALUE;
    
    private void dfs(int u) {
        List<Edge> edges = graph.get(u);
        if (edges == null) {
            return;
        }
        for (Edge e : edges) {
            result = Math.min(result, e.dist);
            if (!visited[e.v]) {
                visited[e.v] = true;
                dfs(e.v);
            }
        }
    }
    
    public int minScore(int n, int[][] roads) {
        graph = new HashMap<>();
        visited = new boolean[n + 1];
        int length = roads.length;
        for (int i = 0; i < length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int dist = roads[i][2];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }
            graph.get(u).add(new Edge(u, v, dist));
            graph.get(v).add(new Edge(v, u, dist));
        }
        dfs(1);
        return result;
    }
}
```
