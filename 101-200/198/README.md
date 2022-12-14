# [House Robber](https://leetcode.com/problems/house-robber/)

Simple dp, `dp[i]` is the maximum amount of money when robbing `nums[i]`. So the state transition equation is `dp[i] = max(dp[i - 2], dp[i - 3]) + nums[i]`.

## code

```java
/**
 * 0 ms, 39.6 MB
 */
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 3];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            int dpi = i + 3;
            dp[dpi] = Math.max(dp[dpi - 2], dp[dpi - 3]) + nums[i];
            result = Math.max(result, dp[dpi]);
        }
        return result;
    }
}
```
