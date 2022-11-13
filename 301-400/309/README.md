# [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

Dp problem.

Solution one, `dp[0][i]` is the maximum profit when buy `prices[i]`, `dp[1][i]` is the maximum profit when sell `prices[i]`. The state transition equation is `dp[0][i] = max(dp[0][i], dp[1][j] - prices[i])`, `dp[1][i] = max(dp[1][i], dp[0][j] + prices[i])`.

Solution two, `dp[0][i]` is the maximum profit when last action is buy. It may not happen at index `i`, it may happen at index `i - 1, i - 2, ..., 0`. `dp[1][i]` is the maximum profit when last action is sell. So the state transition equation is `dp[0][i] = max(dp[0][i - 1], dp[1][i - 2] - prices[i])`, `dp[1][i] = max(dp[1][i - 1], dp[0][i - 1] + prices[i])`.

## code

```java
/**
 * solution one
 * 31 ms, 40.5 MB
 */
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[2][length];
        dp[0][0] = -prices[0];
        dp[1][0] = -5000 * 1002;
        int result = 0;
        for (int i = 1; i <length; i++) {
            dp[0][i] = -prices[i];
            for (int j = i - 1; j >= 0; j--) {
                dp[1][i] = Math.max(dp[1][i], dp[0][j] + prices[i]);
            }
            for (int j = i - 2; j >= 0; j--) {
                dp[0][i] = Math.max(dp[0][i], dp[1][j] - prices[i]);
            }
            result = Math.max(result, dp[1][i]);
        }
        return result;
    }
}
```

```java
/**
 * solution two
 * 1 ms, 40.6 MB
 */
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[2][length];
        dp[0][0] = -prices[0];
        dp[1][0] = 0;
        for (int i = 1; i < length; i++) {
            if (i >= 2) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 2] - prices[i]);
            } else {
                dp[0][i] = Math.max(dp[0][i - 1], -prices[i]);
            }
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i]);
        }
        return dp[1][length - 1];
    }
}
```
