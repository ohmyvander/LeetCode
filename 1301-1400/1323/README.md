# [Maximum 69 Number](https://leetcode.com/problems/maximum-69-number/)

Simple problem.

## code

```java
/**
 * 0 ms, 40.9 MB
 */
class Solution {
    public int maximum69Number (int num) {
        int temp = num;
        for (int i = 1000; i > 0; i /= 10) {
            if (temp / i == 6) {
                return num + 3 * i;
            }
            temp %= i;
        }
        return num;
    }
}
```
