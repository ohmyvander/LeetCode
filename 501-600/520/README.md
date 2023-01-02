# [Detect Capital](https://leetcode.com/problems/detect-capital/)

Simple problem.

## code

```java
/**
 * 1 ms, 40.7 MB
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first = false, upper = false, lower = false;
        char[] chs = word.toCharArray();
        int length = chs.length;
        if (chs[0] >= 'A' && chs[0] <= 'Z') {
            first = true;
        } else {
            lower = true;
        }
        for (int i = 1; i < length; i++) {
            if (chs[i] >= 'A' && chs[i] <= 'Z') {
                upper = true;
            } else {
                lower = true;
            }
        }
        if (upper && lower) {
            return false;
        } 
        return true;
    }
}
```
