# [Find the Pivot Integer](https://leetcode.com/problems/find-the-pivot-integer/)

Simple problem, the sum of a arithmetic progression is `(arr[0] + arr[length - 1]) * length / 2`.

## code

```java
/**
 * 2 ms, 39.7 MB
 */
class Solution {
    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            if ((1 + i) * i / 2 == (i + n) * (n - i + 1) / 2) {
                return i;
            }
        }
        return -1;
    }
}
```
