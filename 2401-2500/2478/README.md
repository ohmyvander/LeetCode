# [Number of Beautiful Partitions](https://leetcode.com/problems/number-of-beautiful-partitions/)

`lens` is an array contains every beautiful partition in `s` without considing `minLength`. `sum[i]` is the sum of `lens[0]...lens[i]`. `dp[i][j]` is the number of beautiful partitions in `lens[0]...lens[i]` and partitioned into `j` non-intersecting substrings.

So the state transition equation is `dp[i][j] = sum(dp[0][j - 1]...dp[idx][j - 1])`, `idx` is the last index of sum number in `sum` which is less equal than `sum[i] - minLength`. Use binary search to find `idx`.

## code

```java
/**
 * 97 ms, 42.8 MB
 */
class Solution {
    private boolean isPrimeDigit(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

    private int bsearchle(int[] sum, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (target == sum[mid]) {
                return mid;
            }
            if (target > sum[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return --l;
    }

    public int beautifulPartitions(String s, int k, int minLength) {
        int length = s.length();
        if (!isPrimeDigit(s.charAt(0)) || isPrimeDigit(s.charAt(length - 1))) {
            return 0;
        }
        int start = 0;
        List<Integer> lens = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            if (!isPrimeDigit(s.charAt(i - 1)) && isPrimeDigit(s.charAt(i))) {
                lens.add(i - start);
                start = i;
            }
        }
        lens.add(length - start);
        length = lens.size();
        if (length < k) {
            return 0;
        }
        int[] sum = new int[length + 1];
        sum[0] = 0;
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + lens.get(i);
        }
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[length + 1][k + 1];
        int[][] dpsum = new int[length + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= length; i++) {
                if (j == 1) {
                    if (sum[i] >= minLength) {
                        dp[i][j] = 1;
                    }
                } else {
                    int idx = bsearchle(sum, 0, i, sum[i] - minLength);
                    if (idx != -1) {
                        dp[i][j] = dpsum[idx][j - 1];
                    }
                }
                dpsum[i][j] = (dpsum[i - 1][j] + dp[i][j]) % mod;
            }
        }
        return dp[length][k];
    }
}
```
