# [Decoded String at Index](https://leetcode.com/problems/decoded-string-at-index/)

Append `1` to the string, and then using these array:
 - `d[i]` is the `ith` digit index of string.
 - `repeat[i]` is the tape length of `ith` digit.
 - `clen` is count of letters between `d[i - 1]` and `d[i]`.

For example, when string is `leat2code3xyz`, then:
```
s = s + '1' = leat2code3xyz1
d: 4 9 13
repeat: 8 36 39
clen: 4 4 3
```

## code

```java
/**
 * 1 ms, 42 MB
 */
class Solution {
    public String decodeAtIndex(String s, int k) {
        s = s + "1";
        int length = s.length();
        long[] repeat = new long[length];
        long[] clen = new long[length];
        int[] d = new int[length];
        int cnt = 0;
        int c = 0;
        long rlen = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                c++;
            } else if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
                int rtime = s.charAt(i) - '0';
                rlen = (rlen + c) * rtime;
                repeat[cnt] = rlen;
                clen[cnt] = c;
                d[cnt++] = i;
                c = 0;
            }
        }
        if (cnt == 0 || k <= d[0]) {
            return String.valueOf(s.charAt(k - 1));
        }
        long kk = k;
        for (int i = cnt - 1; i > 0; i--) {
            int prev = i - 1;
            if (kk > repeat[prev] && kk <= repeat[i]) {
                int digit = s.charAt(d[i]) - '0';
                long unit = repeat[i] / digit;
                long pos = (kk - 1) % unit + 1;
                if (pos > repeat[prev]) {
                    return String.valueOf(s.charAt((int) (d[i - 1] + pos - repeat[prev])));
                } else {
                    kk = pos;
                }
            }
        }
        return String.valueOf(s.charAt((int) ((kk - 1) % d[0])));
    }
}
```
