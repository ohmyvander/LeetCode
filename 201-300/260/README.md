# [Single Number III](https://leetcode.com/problems/single-number-iii/)

According to these xor operating properties:

```
a xor b = b xor a
a xor a = 0
```

Suppose `a` and `b` are two elements appear only once in `nums`. So `temp` is the result doing xor operating with all numbers, which is equal to `a xor b`. If there is a bit number that `temp & bit == 0`, then it must be `a & bit == 0` or `b & bit == 0`. So the nums can be divided into two groups, and doing xor operating with all numbers in each group can get the answer.

## code

```java
/**
 * 5 ms, 44.7 MB
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int length = nums.length;
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int bit = 1;
        while ((bit & temp) == 0) {
            bit *= 2;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] { a, b };
    }
}
```
