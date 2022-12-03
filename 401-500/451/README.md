# [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)

Simple problem.

## code

```java
/**
 * 49 ms, 50.8 MB
 */
class Solution {
    public String frequencySort(String s) {
        long[] map = new long[128];
        for (char c : s.toCharArray()) {
            int idx = c - '0';
            if (map[idx] == 0) {
                map[idx] = ((long) c << 31) + 1;
            } else {
                map[idx]++;
            }
        }
        map = Arrays.stream(map).boxed().sorted((a, b) -> (int) ((b & Integer.MAX_VALUE) - (a & Integer.MAX_VALUE)))
            .mapToLong(i -> i).toArray();
        String result = "";
        for (long num : map) {
            if (num == 0) {
                break;
            }
            int count = (int) (num & Integer.MAX_VALUE);
            char c = (char) (num >> 31);
            result += String.join("", Collections.nCopies(count, String.valueOf(c)));
        }
        return result;
    }
}
```