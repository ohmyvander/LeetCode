# [Target Sum](https://leetcode.com/problems/target-sum/)

To be added....

```java
/**
 * 49 ms, 53.7 MB
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        int max = 2050;
        int[][] dp = new int[length][max];
        if (nums[0] == 0) {
            dp[0][1000] = 2;
        } else {
            dp[0][1000 + nums[0]] = 1;
            dp[0][1000 - nums[0]] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < max; j++) {
                if (j + 1000 + nums[i] < max) {
                    dp[i][j] = dp[i - 1][j + 1000 + nums[i]] + dp[i - 1][j + 1000 - nums[i]];
                } else if (j + 1000 - nums[i] < max) {
                    dp[i][j] = dp[i - 1][j + 1000 - nums[i]];
                }
            }
        }
        return dp[length - 1][1000 + target];
    }
}
```
