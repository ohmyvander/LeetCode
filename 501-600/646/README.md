# [Maximum Length of Pair Chain](https://leetcode.com/problems/maximum-length-of-pair-chain/)

Dp problem, the status transition equation is `dp[i] = max(dp[i], dp[j] + 1)`.

## code

```java
/**
 * 49 ms, 54.7 MB
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int length = pairs.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int result = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[length - 1];
    }
}
```
