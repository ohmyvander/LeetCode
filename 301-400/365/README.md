# [Water and Jug Problem](https://leetcode.com/problems/water-and-jug-problem/)

Every turn, the actual operation is empty a jug or fill a jug (pour water from one into another does not change total water amount). So we can get `a * jug1Capacity + b * jug2Capacity = targetCapacity`.

According to Bézout's identity, if `gcd(x, y) = d`, then `targetCapacity % d = 0`.

## code

```java
/**
 * 0 ms, 41.7 MB
 */
class Solution {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        int g = gcd(jug1Capacity, jug2Capacity);
        return targetCapacity % g == 0 ? true : false;
    }
}
```
