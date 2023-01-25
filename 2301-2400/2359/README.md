# [Find Closest Node to Given Two Nodes](https://leetcode.com/problems/find-closest-node-to-given-two-nodes/)

Solution one, dfs.

Solution two, bfs.

## code

```java
/**
 * solution one
 * 305 ms, 195.1 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;

    private void dfs(int curr, int[] dist, int depth) {
        if (depth >= dist[curr]) {
            return;
        }
        dist[curr] = depth;
        for (Integer next : graph.get(curr)) {
            dfs(next, dist, depth + 1);
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        graph = new HashMap<>();
        int length = edges.length;
        for (int i = 0; i < length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            int u = i;
            int v = edges[i];
            if (v != -1) {
                graph.get(u).add(v);
            }
        }
        int[] dist1 = new int[length];
        int[] dist2 = new int[length];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dfs(node1, dist1, 0);
        dfs(node2, dist2, 0);
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < length; i++) {
            if (dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE) {
                continue;
            }
            int temp = Math.max(dist1[i], dist2[i]);
            if (temp < min) {
                min = temp;
                result = i;
            }
        }
        return result;
    }
}
```

```java
/**
 * solution two
 * 217 ms, 83.7 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;

    private void bfs(int start, int[] dist) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start, 0 });
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curr = node[0];
            int step = node[1];
            if (step >= dist[curr]) {
                continue;
            }
            dist[curr] = step;
            for (Integer next : graph.get(curr)) {
                queue.offer(new int[] { next, step + 1 });
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        graph = new HashMap<>();
        int length = edges.length;
        for (int i = 0; i < length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            int u = i;
            int v = edges[i];
            if (v != -1) {
                graph.get(u).add(v);
            }
        }
        int[] dist1 = new int[length];
        int[] dist2 = new int[length];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        bfs(node1, dist1);
        bfs(node2, dist2);
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < length; i++) {
            if (dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE) {
                continue;
            }
            int temp = Math.max(dist1[i], dist2[i]);
            if (temp < min) {
                min = temp;
                result = i;
            }
        }
        return result;
    }
}
```
