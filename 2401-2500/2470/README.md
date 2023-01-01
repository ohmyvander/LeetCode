# [Number of Subarrays With LCM Equal to K](https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/)

Use `Map` to store the count of subarrays with lcm as key.

## code

```java
/**
 * 8 ms, 42.4 MB
 */
class Solution {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        int g = gcd(a, b);
        return a * b / g;
    }

    public int subarrayLCM(int[] nums, int k) {
        Map<Integer, Integer> prev;
        Map<Integer, Integer> cur = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            prev = cur;
            cur = new HashMap<>();
            Set<Integer> keys = prev.keySet();
            for (Integer key : keys) {
                int val = prev.get(key);
                int l = lcm(key, num);
                if (l > k) {
                    continue;
                }
                cur.put(l, cur.getOrDefault(l, 0) + val);
            }
            cur.put(num, cur.getOrDefault(num, 0) + 1);
            result += cur.getOrDefault(k, 0);
        }
        return result;
    }
}
```
