# [Append Characters to String to Make Subsequence](https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/)

Simple problem.

## code

```java
/**
 * 8 ms, 49.6 MB
 */
class Solution {
    public int appendCharacters(String s, String t) {
        int pos = 0;
        for (int i = 0; i < s.length() && pos < t.length(); i++) {
            if (s.charAt(i) == t.charAt(pos)) {
                pos++;
            }
        }
        return t.length() - pos;
    }
}
```
