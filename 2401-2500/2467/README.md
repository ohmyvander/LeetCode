# [Most Profitable Path in a Tree](https://leetcode.com/problems/most-profitable-path-in-a-tree/)

The graph is a tree with no loop. So fisrt get the path of Bob, then dfs.

## code

```java
/**
 * 108 ms, 108.2 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;
    private int[] bOrder;
    private int result;

    private List<Integer> dfsBob(int cur, int from, Stack<Integer> path) {
        path.push(cur);
        List<Integer> list = null;
        if (cur == 0) {
            list = new ArrayList<>(path);
        }
        for (Integer next : graph.get(cur)) {
            if (next.intValue() != from && list == null) {
                list = dfsBob(next, cur, path);
            }
        }
        path.pop();
        return list;
    }

    private void dfs(int cur, int from, int sum, int deep, int[] amount, int start) {
        if (deep == bOrder[cur]) {
            sum += amount[cur] / 2;
        } else if (bOrder[cur] == 0 || deep < bOrder[cur]) {
            sum += amount[cur];
        }
        List<Integer> nexts = graph.get(cur);
        if (nexts.size() == 1 && cur != start) {
            result = Math.max(result, sum);
            return;
        }
        for (Integer next : nexts) {
            if (next.intValue() != from) {
                dfs(next, cur, sum, deep + 1, amount, start);
            }
        }
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int length = 0;
        graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
            length = Math.max(Math.max(length, u), v);
        }
        length++;
        bOrder = new int[length];
        List<Integer> bPath = dfsBob(bob, -1, new Stack<Integer>());
        for (int i = 0; i < bPath.size(); i++) {
            bOrder[bPath.get(i)] = i + 1;
        }
        result = Integer.MIN_VALUE;
        dfs(0, -1, 0, 1, amount, 0);
        return result;
    }
}
```
