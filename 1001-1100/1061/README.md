# [Lexicographically Smallest Equivalent String](https://leetcode.com/problems/lexicographically-smallest-equivalent-string/)

Similar problem, index link.

## code

```typescript
/**
 * 2 ms, 41 MB
 */
class Solution {
    private char find(int[] map, int idx) {
        while (map[idx] != -1) {
            idx = map[idx];
        }
        return (char) ('a' + idx);
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            c1 = find(map, c1 - 'a');
            c2 = find(map, c2 - 'a');
            if (c1 == c2) {
                continue;
            }
            char temp;
            if (c2 < c1) {
                temp = c1;
                c1 = c2;
                c2 = temp;
            }
            map[c1 - 'a'] = -1;
            map[c2 - 'a'] = c1 - 'a';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            c = find(map, c - 'a');
            sb.append(c);
        }
        return sb.toString();
    }
}
```
