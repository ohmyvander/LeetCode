# [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

Set `sum[i]` is the sum of `nums[0]...nums[i]`. Put count of all sum in a hashmap. Loop the `sum`, when traverse to `sum[i]`, remove the count of sum in `sum[0]...sum[i]` from the hashmap. Then get count of `k - sum[i]` in hashmap.

## code

```java
/**
 * 29 ms, 46.5 MB
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int[] sum = new int[length + 1];
        map.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            map.put(sum[i + 1], map.getOrDefault(sum[i + 1], 0) + 1);
        }
        length = sum.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            int target = sum[i] + k;
            map.put(sum[i], map.getOrDefault(sum[i], 0) - 1);
            result += map.getOrDefault(target, 0);
        }
        return result;
    }
}
```
