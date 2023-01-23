# [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)

Simple problem.

## code

```java
/**
 * 6 ms, 74.4 MB
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n + 1];
        int[] trusts = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            int u = trust[i][0];
            int v = trust[i][1];
            trusts[u]++;
            trusted[v]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0 && trusted[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
```
