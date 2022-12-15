# [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)

Simple dp, the state transition equation is `dp[i][j] = dp[i - 1][j - 1] + 1` when `text1[i] == text2[j]`, or `dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])` when `text1[i] != text2[j]`.

## code

```java
/**
 * 13 ms, 46.1 MB
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        text1 = " " + text1;
        text2 = " " + text2;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
```
