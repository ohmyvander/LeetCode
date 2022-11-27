# [Minimum Penalty for a Shop](https://leetcode.com/problems/minimum-penalty-for-a-shop/)

Simple problem.

## code

```java
/**
 * 16 ms, 42.8 MB
 */
class Solution {
    public int bestClosingTime(String customers) {
        int n = 0;
        int y = 0;
        customers += "#";
        int length = customers.length();
        for (int i = 0; i < length; i++) {
            if (customers.charAt(i) == 'Y') {
                y++;
            } else if (customers.charAt(i) == 'N') {
                n++;
            }
        }
        int penalty = Integer.MAX_VALUE;
        int result = 0;
        int un = 0, uy = 0;
        for (int i = 0; i < length; i++) {
            int temp = un + y - uy;
            if (temp < penalty) {
                penalty = temp;
                result = i;
            }
            if (customers.charAt(i) == 'Y') {
                uy++;
            } else if (customers.charAt(i) == 'N') {
                un++;
            }
        }
        return result;
    }
}
```
