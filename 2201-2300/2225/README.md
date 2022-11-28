# [Find Players With Zero or One Losses](https://leetcode.com/problems/find-players-with-zero-or-one-losses/)

Simple problem, use map.

## code

```java
/**
 * 216 ms, 153.9 MB
 */
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int length = matches.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int w = matches[i][0];
            int l = matches[i][1];
            map.put(w, map.getOrDefault(w, 0));
            map.put(l, map.getOrDefault(l, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                zero.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                one.add(entry.getKey());
            }
        }
        zero.sort(null);
        one.sort(null);
        result.add(zero);
        result.add(one);
        return result;
    }
}
```
