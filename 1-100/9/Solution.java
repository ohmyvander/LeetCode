/**
 * 输入一个int数字，判断是否是回文数字
 * 
 * 字符串处理，也可以通过模10运算得到新的数字和原来判断是否相等
 * 
 * 7 ms, 38.3 MB
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] number = String.valueOf(x).toCharArray();
        int len = number.length;
        int mid = (len + 1) / 2 - 1;
        for (int i = mid; i >= 0; i--) {
            if (number[i] != number[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
