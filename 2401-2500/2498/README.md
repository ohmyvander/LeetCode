# [Frog Jump II](https://leetcode.com/problems/frog-jump-ii/)

Greedy algorithm, the best jump strategy is `stones[0], stones[1], stones[3], ..., stones[2n-1], stones[length - 1]`, then `stones[length - 1], stones[2n], ..., stones[2], stones[0]` back. Or `stones[0], stones[2], stones[4], ..., stones[2n], stones[length - 1]`, then `stones[length - 1], stones[2n - 1], ..., stones[3], stones[1], stones[0]` back. Find the maximum length of a jump.

## code

```java
/**
 * 5 ms, 84.1 MB
 */
class Solution {
    public int maxJump(int[] stones) {
        int length = stones.length;
        if (length <= 3) {
            return stones[length - 1] - stones[0];
        }
        int result = stones[1] - stones[0];
        for (int i = 1; i < length; i += 2) {
            int nexti = i + 2;
            if (nexti >= length) {
                nexti = length - 1;
            }
            result = Math.max(result, stones[nexti] - stones[i]);
        }
        result = Math.max(result, stones[2] - stones[0]);
        for (int i = 2; i < length; i += 2) {
            int nexti = i + 2;
            if (nexti >= length) {
                nexti = length - 1;
            }
            result = Math.max(result, stones[nexti] - stones[i]);
        }
        return result;
    }
}
```
