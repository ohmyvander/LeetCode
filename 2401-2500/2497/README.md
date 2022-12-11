# [Maximum Star Sum of a Graph](https://leetcode.com/problems/maximum-star-sum-of-a-graph/)

Simple problem.

## code

```java
/**
 * 214 ms, 164.6 MB
 */
class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, PriorityQueue<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (!graph.containsKey(u)) {
                graph.put(u, new PriorityQueue<Integer>(Comparator.reverseOrder()));
            }
            if (!graph.containsKey(v)) {
                graph.put(v, new PriorityQueue<Integer>(Comparator.reverseOrder()));
            }
            graph.get(u).add(vals[v]);
            graph.get(v).add(vals[u]);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < vals.length; i++) {
            int temp = vals[i];
            result = Math.max(result, temp);
            if (graph.containsKey(i)) {
                int n = 0;
                PriorityQueue<Integer> q = graph.get(i);
                while (n < k && !q.isEmpty()) {
                    temp += q.remove();
                    result = Math.max(result, temp);
                    n++;
                }
            }
        }
        return result;
    }
}
```
