# [Ugly Number](https://leetcode.com/problems/ugly-number/)

Simple problem.

## code

```java
/**
 * 2 ms, 42.3 MB
 */
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
```