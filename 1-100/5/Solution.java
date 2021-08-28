/**
 * 求最长回文子字符串
 * 
 * 从中间开始往两边暴力计算，代码写的有点懒....
 * 
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
