# [Count the Number of Good Subarrays](https://leetcode.com/problems/count-the-number-of-good-subarrays/)

Sliding window.

## code

```java
/**
 * 3237 ms, 59.8 MB
 */
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        int l = 0;
        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            temp += map.get(nums[r]) - 1;
            while (temp >= k) {
                list.add(new int[]{l, r});
                int lcnt = map.get(nums[l]);
                temp -= lcnt - 1;
                map.put(nums[l], lcnt - 1);
                l++;
            }
        }
        long result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                result += nums.length - list.get(i)[1];
            } else {
                result += (list.get(i)[0] - list.get(i - 1)[0]) * nums.length - list.get(i)[1];
            }
        }
        return result;
    }
}
```

```java
/**
 * 62 ms, 64 MB
 */
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int temp = 0;
        int l = 0;
        long result = 0;
        for (int r = 0; r < length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            temp += map.get(nums[r]) - 1;
            while (temp >= k) {
                result += length - r;
                int lcnt = map.get(nums[l]);
                temp -= lcnt - 1;
                map.put(nums[l], lcnt - 1);
                l++;
            }
        }
        return result;
    }
}
```
