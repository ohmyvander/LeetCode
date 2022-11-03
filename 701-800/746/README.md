# [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

Simple dp, the state transition equation is `dp[i] = min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1])`.

```java
/**
 * 1 ms, 43.5 MB
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[n];
    }
}
```
