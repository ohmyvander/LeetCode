# [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

Solution one, start from middle of the string and expand to both side.

Solution two, dynamic programming, `dp[i][j] = true` if s[i...j] is a palindromic string. So the state transition equation is `dp[i][i] = true`, `dp[i][j] = s[i] == s[j] && (j - i == 1 || dp[i + 1][j - 1])`.

## code

```java
/**
 * solution one
 * 9 ms, 39.3 MB
 */
class Solution {
    private int maxLen = 0;
    private String result = "";
    
    public String longestPalindrome(String s) {
        int len = s.length();
        int right = len / 2;
        int left = right;
        if (len % 2 == 0) {
            left--;
        }
        while (left >= 0) {
            if ((left + 1) * 2 < this.maxLen) {
                break;
            }
            boolean lAbaEnd = false;
            boolean rAbaEnd = false;
            boolean lAaEnd = false;
            boolean rAaEnd = false;
            for (int i = 0; i <= left; i++) {
                if (s.charAt(left - i) == s.charAt(left + i) && !lAbaEnd) {
                    if (i * 2 + 1 > maxLen) {
                        this.maxLen = i * 2 + 1;
                        this.result = s.substring(left - i, left + i + 1);
                    }
                } else {
                    lAbaEnd = true;
                }
                if (s.charAt(right - i) == s.charAt(right + i) && !rAbaEnd) {
                    if (i * 2 + 1 > maxLen) {
                        this.maxLen = i * 2 + 1;
                        this.result = s.substring(right - i, right + i + 1);
                    }
                } else {
                    rAbaEnd = true;
                }
                if (left + i + 1 < len && s.charAt(left - i) == s.charAt(left + i + 1) && !lAaEnd) {
                    if ((i + 1) * 2 > maxLen) {
                        this.maxLen = (i + 1) * 2;
                        this.result = s.substring(left - i, left + i + 2);
                    }
                } else {
                    lAaEnd = true;
                }
                if (right - i - 1 >= 0 && s.charAt(right - i - 1) == s.charAt(right + i) && !rAaEnd) {
                    if ((i + 1) * 2 > maxLen) {
                        this.maxLen = (i + 1) * 2;
                        this.result = s.substring(right - i - 1, right + i + 1);
                    }
                } else {
                    rAaEnd = true;
                }
                if (lAbaEnd && rAbaEnd && lAaEnd && rAaEnd) {
                    break;
                }
            }
            left--;
            right++;
        }
        return result;
    }
}
```

```javascript
/**
 * solution one
 * 110 ms, 45.9 MB
 */
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    var arr = [["", 0, ""]],
        a, b,
        len, i, idx, tmpl, tmps,
        maxlen = 0, str = "";
    len = s.length;
    if (len === 0) {
        return s;
    }
    for (i = 1, idx = 0; i < len; i += 1) {
        arr[idx][0] += s.charAt(i - 1);
        arr[idx][1] += 1;
        arr[idx][2] = s.charAt(i - 1);
        if (s.charAt(i - 1) !== s.charAt(i)) {
            idx += 1;
            arr.push(["", 0, ""]);
        }
    }
    arr[idx][0] += s.charAt(len - 1);
    arr[idx][1] += 1;
    arr[idx][2] = s.charAt(len - 1);
    len = arr.length;
    for (i = 0; i < len; i += 1) {
        tmpl = 1;
        tmps = arr[i][0];
        while (i - tmpl >= 0 && i + tmpl < len) {
            if (arr[i - tmpl][0] === arr[i + tmpl][0]) {
                tmps = arr[i - tmpl][0] + tmps + arr[i + tmpl][0];
                tmpl += 1;
            } else if (arr[i - tmpl][2] === arr[i + tmpl][2]) {
                if (arr[i - tmpl][1] < arr[i + tmpl][1]) {
                    tmps = arr[i - tmpl][0] + tmps + arr[i - tmpl][0];
                } else {
                    tmps = arr[i + tmpl][0] + tmps + arr[i + tmpl][0];
                }
                break;
            } else {
                break;
            }
        }
        if (tmps.length > maxlen) {
            maxlen = tmps.length;
            str = tmps;
        }
    }
    return str;
};
```

```java
/**
 * solution two
 * 220 ms, 72.2 MB
 */
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String result = s.substring(0, 1);
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i == 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}
```
