# [Maximum Ice Cream Bars](https://leetcode.com/problems/maximum-ice-cream-bars/)

Not a dp problem, just sort the array first and then use greedy algorithm.

## code

```java
/**
 * 39 ms, 55.9 MB
 */
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins - costs[i] >= 0) {
                coins -= costs[i];
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
```
