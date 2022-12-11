# [Maximum Value of a String in an Array](https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/)

Simple problem.

## code

```java
/**
 * 2 ms, 41.6 MB
 */
class Solution {
    public int maximumValue(String[] strs) {
        int result = 0;
        boolean number;
        for (String str : strs) {
            number = true;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    result = Math.max(result, str.length());
                    number = false;
                    break;
                }
            }
            if (number) {
                result = Math.max(result, Integer.parseInt(str));
            }
        }
        return result;
    }
}
```
