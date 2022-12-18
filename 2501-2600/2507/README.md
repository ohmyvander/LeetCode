# [Smallest Value After Replacing With Sum of Prime Factors](https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/)

Brute force and recursion.

## code

```java
/**
 * 3 ms, 39.2 MB
 */
class Solution {
    public int smallestValue(int n) {
        int sum = 0;
        int origin = n;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                n /= i;
                sum += i;
                i--;
            }
        }
        return sum == origin ? sum : smallestValue(sum);
    }
}
```
