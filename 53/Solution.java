/**
 * 求最大连续子串和
 *
 * 简单dp，还久没写了，稍微想了一会儿
 * 状态转移方程：dp[i] = Math.max(dp[i- 1] + nums[i], nums[i])
 * dp[i]表示当包含nums[i]时到i为止数组的最大连续子串和
 * 一次遍历过程中不断取最大的dp[i]
 *
 * 1ms, 38.6 MB
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            int prev = dp[i - 1] + nums[i];
            dp[i] = nums[i] > prev ? nums[i] : prev;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
