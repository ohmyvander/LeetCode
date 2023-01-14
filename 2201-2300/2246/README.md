# [Longest Path With Different Adjacent Characters](https://leetcode.com/problems/longest-path-with-different-adjacent-characters/)

Dfs, can not be hard problem.

## code

```java
/**
 * 340 ms, 128.5 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;
    private int result;

    private int dfs(int cur, int from, String s) {
        List<Integer> nexts = graph.get(cur);
        if (nexts.size() == 1 && nexts.get(0) == from) {
            result = Math.max(result, 1);
            return 1;
        }
        int temp = 1;
        List<Integer> subs = new ArrayList<>();
        subs.add(0);
        subs.add(0);
        for (Integer next : nexts) {
            if (next == from) {
                continue;
            }
            int sub = dfs(next, cur, s);
            if (s.charAt(cur) != s.charAt(next)) {
                subs.add(sub);
                temp = Math.max(temp, 1 + sub);
            }
        }
        subs.sort(Comparator.reverseOrder());
        result = Math.max(result, 1 + subs.get(0) + subs.get(1));
        return temp;
    }

    public int longestPath(int[] parent, String s) {
        graph = new HashMap<>();
        result = 0;
        for (int i = 0; i < parent.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                continue;
            }
            int u = parent[i];
            int v = i;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1, s);
        return result;
    }
}
```
