# [Path with Maximum Probability](https://leetcode.com/problems/path-with-maximum-probability/)

Dijkstra, to be upgraded....

## code

```java
/**
 * 240 ms, 122.4 MB
 */
class Solution {
    private static class Node {
        int u;
        double dist;
        public Node(int u, double dist) {
            this.u = u;
            this.dist = dist;
        }
        public double getDist() {
            return this.dist;
        }
    }

    private double[] dist;
    private boolean[] visited;
    private Queue<Node> queue;
    private Map<Integer, List<Node>> e;

    private double dijkstra(int start, int end) {
        queue = new PriorityQueue<>(Comparator.comparing(Node::getDist, Comparator.reverseOrder()));
        queue.add(new Node(start, 0));
        dist[start] = 1;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int u = node.u;
            if (u == end) {
                break;
            }
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            List<Node> points = e.getOrDefault(u, new ArrayList<>());
            for (Node point : points) {
                int v = point.u;
                if (!visited[v] && dist[u] * point.dist > dist[v]) {
                    dist[v] = dist[u] * point.dist;
                    queue.add(new Node(v, dist[v]));
                }
            }
        }
        return dist[end];
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        e = new HashMap<>();
        dist = new double[n];
        visited = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            if (!e.containsKey(edges[i][0])) {
                e.put(edges[i][0], new ArrayList<>());
            }
            if (!e.containsKey(edges[i][1])) {
                e.put(edges[i][1], new ArrayList<>());
            }
            e.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));
            e.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));
        }
        return dijkstra(start, end);
    }
}
```
