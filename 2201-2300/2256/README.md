# [Minimum Average Difference](https://leetcode.com/problems/minimum-average-difference/)

Simple problem.

## code

```java
/**
 * 25 ms, 77.5 MB
 */
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int length = nums.length;
        long[] sum = new long[length];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < length; i++) {
            long ava = sum[i] / (i + 1);
            long avb = i == length - 1 ? 0L : (sum[length - 1] - sum[i]) / (length - i - 1);
            int temp = (int) Math.abs(ava - avb);
            if (temp < min) {
                min = temp;
                result = i;
            }
        }
        return result;
    }
}
```
