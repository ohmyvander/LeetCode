# [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/)

Set `min` is the minimum sum of subarray when `nums` is not a cirular, `max` is the maximum sum of subarray when `nums` is not a cirular, `sum` is the sum of `nums`. If `sum(nums[i], ..., nums[j])` is the answer, then we can get `sum(nums[i], ..., nums[j]) = max`, `min > sum - max`. Similarly if `sum(nums[0], ..., nums[i - 1]) + sum(nums[j + 1], ..., nums[length - 1])` is the answer, then `sum(nums[i], ..., nums[j]) = min`, `sum - min > max`.

## code

```java
/**
 * 6 ms, 49.3 MB
 */
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int length = nums.length;
        int[] mindp = new int[length];
        int[] maxdp = new int[length];
        mindp[0] = nums[0];
        maxdp[0] = nums[0];
        int min = nums[0], max = nums[0], sum = nums[0];
        for (int i = 1; i < length; i++) {
            mindp[i] = Math.min(mindp[i - 1] + nums[i], nums[i]);
            maxdp[i] = Math.max(maxdp[i - 1] + nums[i], nums[i]);
            sum += nums[i];
            min = Math.min(min, mindp[i]);
            max = Math.max(max, maxdp[i]);
        }
        return sum - min < max || sum == min ? max : sum - min;
    }
}
```
