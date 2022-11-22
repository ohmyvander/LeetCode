# [Perfect Squares](https://leetcode.com/problems/perfect-squares/)

Simple dp, two-dimensional 01 knapsack, unlimited item.
The state transition equation is `dp[i] = min(dp[i], dp[i - items[k]] + 1)`

## code

```java
/**
 * 58 ms, 43.8 MB
 */
class Solution {
    public int numSquares(int n) {
        int[] items = new int[105];
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            items[cnt++] = i * i;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int k = 0; k < cnt; k++) {
            for (int i = items[k]; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - items[k]] + 1);
            }
        }
        return dp[n];
    }
}
```
