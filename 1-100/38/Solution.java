/**
 * 递归+字符串处理，水题
 * 
 * 1 ms, 36.7 MB
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prevSay = countAndSay(n - 1);
        StringBuilder result = new StringBuilder("");
        int num = 1;
        char[] str = prevSay.toCharArray();
        int len = str.length;
        for (int i = 1; i < len; i++) {
            int pi = i - 1;
            if (str[pi] == str[i]) {
                num++;
            } else {
                result.append(num);
                result.append(str[pi]);
                num = 1;
            }
        }
        result.append(num);
        result.append(str[len - 1]);
        return result.toString();
    }
}
