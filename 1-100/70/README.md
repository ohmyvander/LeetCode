# [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

Simple dp, the state transition equation: `dp[i] += dp[i - k]`

## code

```java
/**
 * 0 ms, 40.5 MB
 */
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= 2; k++) {
                if (i - k >= 0) {
                    dp[i] += dp[i - k];
                }
            }
        }
        return dp[n];
    }
}
```
