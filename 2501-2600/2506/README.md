# [Count Pairs Of Similar Strings](https://leetcode.com/problems/count-pairs-of-similar-strings/)

Transfer string to mask.

## code

```java
/**
 * 7 ms, 45.2 MB
 */
class Solution {
    public int similarPairs(String[] words) {
        int length = words.length;
        int[] nums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            int num = 0;
            for (char c : words[i].toCharArray()) {
                int bit = 1 << (c - 'a');
                num |= bit;
            }
            nums[i] = num;
        }
        nums[length] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int start = 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                int count = i - start;
                result += count * (count - 1) / 2;
                start = i;
            }
        }
        return result;
    }
}
```

```java
/**
 * 4 ms, 41.7 MB
 */
class Solution {
    public int similarPairs(String[] words) {
        int length = words.length;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (String word : words) {
            int num = 0;
            for (char c : word.toCharArray()) {
                int mask = 1 << (c - 'a');
                num |= mask; 
            }
            map.put(num, map.getOrDefault(num, -1) + 1);
            result += map.get(num);
        }
        return result;
    }
}
```
