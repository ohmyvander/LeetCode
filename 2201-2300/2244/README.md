# [Minimum Rounds to Complete All Tasks](https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/)

Simple problem.

## code

```java
/**
 * 92 ms, 107.8 MB
 */
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int result = 0;
        for (Integer value : map.values()) {
            if (value == 1) {
                return -1;
            } else if (value % 3 != 0) {
                result += value / 3 + 1;
            } else {
                result += value / 3;
            }
        }
        return result;
    }
}
```
