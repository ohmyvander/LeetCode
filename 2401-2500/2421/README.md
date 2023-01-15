# [Number of Good Paths](https://leetcode.com/problems/number-of-good-paths/)

To be added....

## code

```java
/**
 * 156 ms, 73.1 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;
    private int result;

    private TreeMap<Integer, Integer> dfs(int cur, int from, int[] vals) {
        result += 1;
        List<Integer> nexts = graph.get(cur);
        int val = vals[cur];
        TreeMap<Integer, Integer> paths = new TreeMap<>();
        if (nexts.size() == 1 && nexts.get(0) == from) {
            paths.put(val, 1);
            return paths;
        }
        paths.put(val, paths.getOrDefault(val, 0) + 1);
        for (Integer next : nexts) {
            if (next == from) {
                continue;
            }
            TreeMap<Integer, Integer> subPaths = dfs(next, cur, vals);
            Iterator<Map.Entry<Integer, Integer>> iterator = subPaths.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getKey() < val) {
                    iterator.remove();
                } else {
                    break;
                }
            }
            if (paths.size() < subPaths.size()) {
                TreeMap<Integer, Integer> temp = subPaths;
                subPaths = paths;
                paths = temp;
            }
            for (Map.Entry<Integer, Integer> entry : subPaths.entrySet()) {
                int subVal = entry.getKey();
                int subCount = entry.getValue();
                int temp = paths.getOrDefault(subVal, 0);
                result += temp * subCount;
                paths.put(subVal, temp + subCount);
            }
        }
        return paths;
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        graph = new HashMap<>();
        result = 0;
        for (int i = 0; i < vals.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1, vals);
        return result;
    }
}
```
