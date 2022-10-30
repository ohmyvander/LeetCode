# [Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)

Simple problem, for loop once.

```java
/**
 * 2 ms, 56.2 MB
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int tempMax = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempMax++;
            } else {
                result = Math.max(result, tempMax);
                tempMax = 0;
            }
        }
        result = Math.max(result, tempMax);
        return result;
    }
}
```
