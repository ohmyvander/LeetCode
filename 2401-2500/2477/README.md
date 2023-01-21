# [Minimum Fuel Cost to Report to the Capital](https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/)

Dfs and greedy algorithm.

## code

```java
/**
 * 117 ms, 121.9 MB
 */
class Solution {
    private Map<Integer, List<Integer>> graph;

    private long[] dfs(int cur, int from, int seats) {
        List<Integer> nexts = graph.get(cur);
        if (nexts.size() == 1 && from == nexts.get(0)) {
            return new long[] { 1, 1 };
        }
        long people = 1;
        long fuel = 0;
        for (Integer next : nexts) {
            if (next == from) {
                continue;
            }
            long[] temp = dfs(next, cur, seats);
            fuel += temp[0];
            people += temp[1];
        }
        if (cur == 0) {
            return new long[] { fuel, people - 1 };
        } else {
            return new long[] { fuel + (people + seats - 1) / seats, people };
        }
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        graph = new HashMap<>();
        int length = roads.length;
        for (int i = 0; i <= length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        long[] result = dfs(0, -1, seats);
        return result[0];
    }
}
```
