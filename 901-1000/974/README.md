# [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/)

Set `sum[i]` is the sum of `nums[0]...nums[i]`. If `nums[i]...nums[j]` is a qualified subarray, then `(sum[j] - sum[i - 1]) % k = 0`, and so `sum[i - 1] % k = sum[j] % k`. So the answer is count of pair where `sum[i] % k = sum[j] % k`.

Notice that if `sum[i] < 0, 0 < sum[j] < k, sum[j] - sum[i] = k`, then `sum[i]` and `sum[j]` can be a pair. Add `k` to `sum[i]` to make `sum[i]` be positive.

## code

```java
/**
 * 19 ms, 48.2 MB
 */
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            sum = (sum % k + k) % k;
            int count = map.getOrDefault(sum, 0);
            result += count;
            map.put(sum, count + 1);
        }
        return result;
    }
}
```
