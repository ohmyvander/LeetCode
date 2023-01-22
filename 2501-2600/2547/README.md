# [Minimum Cost to Split an Array](https://leetcode.com/problems/minimum-cost-to-split-an-array/)

Dp problem, first `count[i][j]` is trimmed size of `nums[i]...nums[j]`, and the state transition equation is `dp[i] = min(dp[i], dp[j] + count[j + 1][i] + k)`.

## code

```java
/**
 * 239 ms, 118.2 MB
 */
class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[][] count = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] map = new int[n];
            for (int j = i; j < n; j++) {
                map[nums[j]]++;
                int icnt = map[nums[j]];
                int picnt = icnt - 1 > 1 ? icnt - 1 : 0;
                icnt = icnt > 1 ? icnt : 0;
                if (i < j) {
                    count[i][j] = count[i][j - 1] - picnt + icnt;
                }
            }
        }
        long result = Long.MAX_VALUE;
        long[] dp = new long[n];
        dp[0] = k;
        for (int i = 1; i < n; i++) {
            dp[i] = count[0][i] + k;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + count[j + 1][i] + k);
            }
        }
        return (int) dp[n - 1];
    }
}
```
