# [Determine if String Halves Are Alike](https://leetcode.com/problems/determine-if-string-halves-are-alike/)

Simple problem.

## code

```java
/**
 * 7 ms, 37.6 MB
 */
class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (i < length / 2) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count == 0;
    }
}
```
