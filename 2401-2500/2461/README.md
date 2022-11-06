# [Maximum Sum of Distinct Subarrays With Length K](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/)

Simple problem, sliding window algorithm.

## code

```java
/**
 * 19 ms, 102.4 MB
 */
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] map = new int[100005];
        int length = nums.length;
        int l = 0;
        long result = 0;
        long tempMax = 0;
        for (int r = 0; r < length; r++) {
            map[nums[r]]++;
            tempMax += nums[r];
            while (map[nums[r]] > 1 || r - l + 1 > k) {
                map[nums[l]]--;
                tempMax -= nums[l];
                l++;
            }
            if (r - l + 1 == k) {
                result = Math.max(result, tempMax);
            }
        }
        return result;
    }
}
```
