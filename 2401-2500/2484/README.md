# [Count Palindromic Subsequences](https://leetcode.com/problems/count-palindromic-subsequences/)

`length` is the length of `s`, `cnt[i][j]` is the count of number `j` which is converted from two characters subsequence in `s[0]...s[i]`, `recnt[j][j]` is the count of number `j` which is converted from two characters subsequence in `s[i]...s[length - 1]`. So the result is `sum(cnt[i][j] * recnt[i + 2][j])`, where `0 <= i < length - 2` and `0 <= j <= 99`.

## code

```java
/**
 * 69 ms, 56.9 MB
 */
class Solution {
    public int countPalindromes(String s) {
        int length = s.length();
        int[] digit = new int[10];
        int[][] cnt = new int[length][100];
        int[][] recnt = new int[length][100];
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            int d = chars[i] - '0';
            for (int j = 0; j < 10; j++) {
                int num = j * 10 + d;
                cnt[i][num] = digit[j];
            }
            for (int j = 0; j < 100 && i > 0; j++) {
                cnt[i][j] += cnt[i - 1][j];
            }
            digit[d]++;
        }
        Arrays.fill(digit, 0);
        for (int i = length - 1; i >= 0; i--) {
            int d = chars[i] - '0';
            for (int j = 0; j < 10; j++) {
                int num = j * 10 + d;
                recnt[i][num] = digit[j];
            }
            for (int j = 0; j < 100 && i < length - 1; j++) {
                recnt[i][j] += recnt[i + 1][j];
            }
            digit[d]++;
        }
        long result = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j < 100; j++) {
                result += (long) cnt[i][j] * recnt[i + 2][j];
                result %= mod;
            }
        }
        return (int) result;
    }
}
```
