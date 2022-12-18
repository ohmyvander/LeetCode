# [Minimum Total Distance Traveled](https://leetcode.com/problems/minimum-total-distance-traveled/)

The size of robot is `rlen`, and the size of factory is `flen`;

Solution one, use dfs. `dfs(i, j)` means the minimum distance when `robot[i], ..., robot[rlen - 1]` are repaired by `factory[j], ..., factory[flen - 1]`.

Solution two, use dp. `dp[i][j]` means first `j` robots are repaired by first `i` factories, where `i` and `j` are amount but not index. So the state transition equation is `dp[i][j] = min(dp[i][j], dp[i - 1][j - k] + tempdis)`.

Both two solution should loop `limit` of each factory.

## code

```java
/**
 * solution one
 * 52 ms, 41.6 MB
 */
class Solution {
    private long[][] mindis;

    private long dfs(int m, int n, List<Integer> robot, int[][] factory) {
        int rlen = robot.size();
        int flen = factory.length;
        if (m == rlen) {
            return 0;
        }
        if (mindis[m][n] != -1) {
            return mindis[m][n];
        }
        if (n == flen - 1) {
            int remain = rlen - m;
            if (factory[n][1] < remain) {
                mindis[m][n] = Long.MAX_VALUE;
                return mindis[m][n];
            }
            long sum = 0;
            for (int i = m; i < rlen; i++) {
                sum += Math.abs(robot.get(i) - factory[n][0]);
            }
            mindis[m][n] = sum;
            return mindis[m][n];
        }
        long result = dfs(m, n + 1, robot, factory);
        long temp = 0;
        for (int i = m; i < rlen && i - m + 1 <= factory[n][1]; i++) {
            temp += Math.abs(robot.get(i) - factory[n][0]);
            long sub = dfs(i + 1, n + 1, robot, factory);
            result = Math.min(result, sub == Long.MAX_VALUE ? sub : temp + sub);
        }
        mindis[m][n] = result;
        return result;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(null);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        mindis = new long[robot.size()][factory.length];
        for (int i = 0; i < robot.size(); i++) {
            for (int j = 0; j < factory.length; j++) {
                mindis[i][j] = -1;
            }
        }
        return dfs(0, 0, robot, factory);
    }
}
```

```java
/**
 * solution one
 * 65 ms, 43.4 MB
 */
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(null);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        int rlen = robot.size();
        int flen = factory.length;
        long[][] dp = new long[flen + 1][rlen + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= rlen; i++) {
            dp[0][i] = Long.MAX_VALUE;
        }
        for (int i = 1; i <= flen; i++) {
            int fi = i - 1;
            for (int j = 1; j <= rlen; j++) {
                int ri = j - 1;
                dp[i][j] = dp[i - 1][j];
                long sum = 0;
                for (int k = ri, cnt = 1; k >= 0 && k > ri - factory[fi][1]; k--, cnt++) {
                    sum += Math.abs(robot.get(k) - factory[fi][0]);
                    long sub = dp[i - 1][j - cnt];
                    dp[i][j] = Math.min(dp[i][j], sub == Long.MAX_VALUE ? sub : sub + sum);
                }
            }
        }
        return dp[flen][rlen];
    }
}
```
