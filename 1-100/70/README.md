# [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

Simple dp, the state transition equation: `dp[i] += dp[i - k]`

## code

```java
/**
 * 0 ms, 40.5 MB
 */
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= 2; k++) {
                if (i - k >= 0) {
                    dp[i] += dp[i - k];
                }
            }
        }
        return dp[n];
    }
}
```

```python
class Solution:
    '''
    36 ms, 13.9 MB
    '''
    def climbStairs(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = 1
        for i in range(1, n + 1):
            for k in range(1, 3):
                if i - k < 0:
                    continue
                if dp[i] == 0:
                    dp[i] = dp[i - k]
                elif i - k >= 0:
                    dp[i] += dp[i - k]
        return dp[n]
```
