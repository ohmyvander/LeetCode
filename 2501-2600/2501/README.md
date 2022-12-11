# [Longest Square Streak in an Array](https://leetcode.com/problems/longest-square-streak-in-an-array/)

Simple problem, sort first.

## code

```java
/**
 * 108 ms, 122.3 MB
 */
class Solution {
    private int sqrt(int num) {
        int sqrt = (int) Math.sqrt((double) num);
        if (sqrt * sqrt == num) {
            return sqrt;
        }
        return -1;
    }
        
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] map = new int[100050];
        int result = 0;
        for (int i = 0; i < length; i++) {
            int sqrt = sqrt(nums[i]);
            if (sqrt == -1) {
                map[nums[i]] = 1;
            } else {
                map[nums[i]] = map[sqrt] + 1;
            }
            result = Math.max(result, map[nums[i]]);
        }
        return result == 1 ? -1 : result;
    }
}
```

```java
/**
 * 180 ms, 108.7 MB
 */
class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        Map<Long, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            long temp = nums[i];
            map.put(temp, map.getOrDefault(temp * temp, 0) + 1);
            result = Math.max(result, map.get(temp).intValue());
        }
        return result == 1 ? -1 : result;
    }
}
```
