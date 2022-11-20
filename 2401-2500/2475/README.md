# [Number of Unequal Triplets in Array](https://leetcode.com/problems/number-of-unequal-triplets-in-array/)

Simple problem.

## code

```java
/**
 * 0 ms, 42.5 MB
 */
class Solution {
    public int unequalTriplets(int[] nums) {
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
```
