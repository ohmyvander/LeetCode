# [Target Sum](https://leetcode.com/problems/target-sum/)

Obviously dp problem, since `0 <= sum <= 1000` and `-1000 <= target <= 1000`, so the maximum length of dp array is `2000`. Plus `1000` to every sum to make index positive. `dp[i][1000 + j]` is the number of different expressions when using numbers `nums[0]...nums[i]` builded to evaluate `j`. The state transition equation is when `j + 1000 + nums[i] < max`, `dp[i][j] = dp[i - 1][j + 1000 + nums[i]] + dp[i - 1][j + 1000 - nums[i]]`, when `j + 1000 - nums[i] < max`, `dp[i][j] = dp[i - 1][j + 1000 - nums[i]]`.

Also, set the sum of all numbers with symbol `+` added is `a`, the sum of all numbers with symbol `-` added is `b`. So we can get `a + b = sum` and `a - b = target`, then `b = (sum - target) / 2` and `b` must be even. Now it become a 01 knapsack problem with limited items. `dp[i]` is the number of different expressions when `b = i`. The state transition equation is `dp[i] = nums[k] == 0 ? dp[i] * 2 : dp[i] + dp[i - nums[k]]`.

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

```java
/**
 * 2 ms, 40.2 MB
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        int value = Math.abs(sum - target);
        if (value % 2 == 1 || sum < target) {
            return 0;
        }
        value /= 2;
        int[] dp = new int[value + 1];
        dp[0] = 1;
        for (int k = 0; k < length; k++) {
            for (int i = value; i >= nums[k]; i--) {
                dp[i] = nums[k] == 0 ? dp[i] * 2 : dp[i] + dp[i - nums[k]];
            }
        }
        return dp[value];
    }
}
```
