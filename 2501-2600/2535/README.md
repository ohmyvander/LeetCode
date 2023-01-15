# [Difference Between Element Sum and Digit Sum of an Array](https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/)

Simple problem.

## code

```java
/**
 * 3 ms, 42.2 MB
 */
class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int dsum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = nums[i];
            while (temp != 0) {
                dsum += temp % 10;
                temp /= 10;
            }
        }
        return Math.abs(sum - dsum);
    }
}
```
