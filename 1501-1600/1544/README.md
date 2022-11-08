# [Make The String Great](https://leetcode.com/problems/make-the-string-great/)

Simple problem, use stack.

## code

```java
/**
 * 1 ms, 41.1 MB
 */
class Solution {
    public String makeGood(String s) {
        int length = s.length();
        char[] stack = new char[length];
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            stack[cnt++] = s.charAt(i);
            while (cnt >= 2 && stack[cnt - 2] != stack[cnt - 1]
            && Character.toLowerCase(stack[cnt - 2]) == Character.toLowerCase(stack[cnt - 1])) {
                cnt -= 2;
            }
        }
        return new String(Arrays.copyOf(stack, cnt));
    }
}
```
