# [Number of Distinct Averages](https://leetcode.com/problems/total-cost-to-hire-k-workers/)

Simple problem.

## code

```java
/**
 * 3 ms, 42.4 MB
 */
class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Map<Double, Boolean> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            map.put(((double) nums[i] + (double) nums[length - 1 - i]) / 2.0, true);
        }
        return map.keySet().size();
    }
}
```
