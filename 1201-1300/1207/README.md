# [Unique Number of Occurrences](https://leetcode.com/problems/unique-number-of-occurrences/)

Simple problem.

## code

```java
/**
 * 3 ms, 41.9 MB
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] nums = Arrays.copyOf(arr, arr.length + 1);
        int length = nums.length;
        nums[length - 1] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        boolean[] map = new boolean[1005];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (map[count]) {
                    return false;
                }
                map[count] = true;
                count = 1;
            }
        }
        return true;
    }
}
```
