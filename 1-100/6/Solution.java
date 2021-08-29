/**
 * 输出字符串
 * 
 * 4 ms, 42.1 MB
 */
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || len <= numRows) {
            return s;
        }
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < numRows && i < len; i++) {
            int j = i;
            while (j < len) {
                str.append(s.charAt(j));
                int next = j + numRows * 2 - 2;
                int temp = next - i * 2;
                if (i != 0 && i != numRows - 1 && temp < len) {
                    str.append(s.charAt(temp));
                }
                j = next;
            }
        }
        return str.toString();
    }
}
