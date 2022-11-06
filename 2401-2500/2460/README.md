# [Apply Operations to an Array](https://leetcode.com/problems/apply-operations-to-an-array/)

Simple problem.

## code

```java
/**
 * 1 ms, 45 MB
 */
class Solution {
    public int[] applyOperations(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }
        int[] result = new int[length];
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                result[cnt++] = nums[i];
            }
        }
        return result;
    }
}
```
