# [Count Ways To Build Good Strings](https://leetcode.com/problems/count-ways-to-build-good-strings/)

Simple dp, the state transition equation: `dp[i] += dp[i - k]`.

## code

```java
/**
 * 23 ms, 43.8 MB
 */
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int base = (int) Math.pow(10, 9) + 7;
        int[] nums = {zero, one};
        int[] dp = new int[high + 1];
        for (int i = 1; i <= high; i++) {
            for (int k = 0; k < 2; k++) {
                if (i == nums[k]) {
                    dp[i] = dp[i] + 1;
                } else if (i > nums[k]) {
                    dp[i] = dp[i] + dp[i - nums[k]];
                }
            }
            dp[i] %= base;
        }
        int result = 0;
        for (int i = low; i <= high; i++) {
            result += dp[i];
            result %= base;
        }
        return result;
    }
}
```
