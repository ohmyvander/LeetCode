# [Minimum Time to Collect All Apples in a Tree](https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/)

Get the number of edges of a minimum tree which contains `m` marked nodes. Then answer is twice the number.

Actually, a tree with `e` edges always contains `e + 1` nodes. So dfs the tree, if the node is leaf node and it is marked, then retuan 2, else return sum result of all sub trees. Then the answer is sum minus two.

## code

```java
/**
 * 59 ms, 85.2 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;

    private int dfs(List<Boolean> hasApple, int cur, int from) {
        List<Integer> nexts = graph.get(cur);
        if (nexts.size() == 1 && nexts.get(0) == from) {
            if (hasApple.get(cur)) {
                return 2;
            } else {
                return 0;
            }
        }
        int result = 0;
        for (Integer next : nexts) {
            if (next == from) {
                continue;
            }
            result += dfs(hasApple, next, cur);
        }
        if (result != 0 || hasApple.get(cur)) {
            result += 2;
        }
        return result;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graph = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            count += hasApple.get(i) ? 1 : 0;
        }
        if (count == 0) {
            return 0;
        } else if (count == n) {
            return (n - 1) * 2;
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return dfs(hasApple, 0, -1) - 2;
    }
}
```
