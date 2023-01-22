# [Alternating Digit Sum](https://leetcode.com/problems/alternating-digit-sum/)

Simple problem.

## code

```java
/**
 * 0 ms, 39 MB
 */
class Solution {
    public int alternateDigitSum(int n) {
        int[] d = new int[15];
        int cnt = 0;
        while (n != 0) {
            d[cnt++] = n % 10;
            n /= 10;
        }
        int flag = 1;
        int result = 0;
        for (int i = cnt - 1; i >= 0; i--) {
            result += d[i] * flag;
            flag *= -1;
        }
        return result;
    }
}
```
