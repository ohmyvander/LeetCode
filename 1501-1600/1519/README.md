# [Number of Nodes in the Sub-Tree With the Same Label](https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/)

Simple problem, dfs.

## code

```java
/**
 * 98 ms, 113.7 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;
    private int[] result;

    private int[] dfs(int cur, int from, String labels) {
        List<Integer> nexts = graph.get(cur);
        int[] count = new int[26];
        count[labels.charAt(cur) - 'a'] = 1;
        if (nexts.size() == 1 && nexts.get(0) == from) {
            result[cur] = 1;
            return count;
        }
        for (Integer next : nexts) {
            if (next == from) {
                continue;
            }
            int[] temp = dfs(next, cur, labels);
            for (int i = 0; i < 26; i++) {
                count[i] += temp[i];
            }
        }
        result[cur] = count[labels.charAt(cur) - 'a'];
        return count;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        graph = new HashMap<>();
        result = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1, labels);
        return result;
    }
}
```
