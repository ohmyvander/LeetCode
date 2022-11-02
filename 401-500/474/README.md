# [Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/)

Simple dynamic programming, two-dimensional 01 knapsack. Limited item.

The state transition equation: `dp[i][j] = max(dp[i][j], dp[i - m[k]][j - n[k]] + 1)`

## code

```java
/**
 * 62 ms, 42.9 MB
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[] ms = new int[length];
        int[] ns = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    ms[i]++;
                } else {
                    ns[i]++;
                }
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < length; k++) {
            for (int i = m; i >= ms[k]; i--) {
                for (int j = n; j >= ns[k]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - ms[k]][j - ns[k]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
```