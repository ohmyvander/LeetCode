# [Apply Bitwise Operations to Make Strings Equal](https://leetcode.com/problems/apply-bitwise-operations-to-make-strings-equal/)

Simple problem, `11 -> 10 or 01, 00 -> 00, 10 -> 01, 01 -> 10`.

## code

```java
/**
 * 7 ms, 43 MB
 */
class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {
            return true;
        }
        int n = s.length();
        boolean one = false, zero = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == target.charAt(i)) {
                if (s.charAt(i) == '1') {
                    return true;
                }
            } else if (s.charAt(i) == '0') {
                zero = true;
            } else {
                one = true;
            }
        }
        return zero && one;
    }
}
```
