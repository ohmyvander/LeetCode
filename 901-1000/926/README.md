# [Flip String to Monotone Increasing](https://leetcode.com/problems/flip-string-to-monotone-increasing/)

Dp problem, `dp[0][i]` is the minimum number of flips when `s[i]` change to `0` and `s[0...i]` is monotone increasing, so as `dp[1][i]`. The state transition equation is `dp[0][i] = dp[0][i - 1] + flip`, `dp[1][i] = min(dp[0][i - 1], dp[1][i - 1] + flip)`.

## code

```java
/**
 * 19 ms, 43.1 MB
 */
class Solution {
    public int minFlipsMonoIncr(String s) {
        int length = s.length();
        int[][] dp = new int[2][length];
        for (int i = 0; i < length; i++) {
            int toZero = s.charAt(i) == '0' ? 0 : 1;
            int toOne = s.charAt(i) == '1' ? 0 : 1;
            if (i == 0) {
                dp[0][0] = toZero;
                dp[1][0] = toOne;
                continue;
            }
            dp[0][i] = dp[0][i - 1] + toZero;
            dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + toOne;
        }
        return Math.min(dp[0][length - 1], dp[1][length - 1]);
    }
}
```
