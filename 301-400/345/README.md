# [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)

Simple problem.

```java
/**
 * 271 ms, 248.9 MB
 */
class Solution {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int length = chs.length;
        int[] pos = new int[length];
        int cnt = 0;
        String temp = "";
        for (int i = 0; i < length; i++) {
            if (chs[i] == 'a' || chs[i] == 'A'
            || chs[i] == 'e' || chs[i] == 'E'
            || chs[i] == 'i' || chs[i] == 'I'
            || chs[i] == 'o' || chs[i] == 'O'
            || chs[i] == 'u' || chs[i] == 'U') {
                temp += chs[i];
                pos[cnt++] = i;
            }
        }
        temp = new StringBuilder(temp).reverse().toString();
        for (int i = 0; i < cnt; i++) {
            chs[pos[i]] = temp.charAt(i);
        }
        return new String(chs);
    }
}
```
