/**
 * 输入一个字符串，输出对应转化的int数字。实现类似c中atoi函数
 * 
 * 字符串处理，利用Integer.parseInt和try catch实现
 * 
 * 3 ms, 39 MB
 */
class Solution {
    public int myAtoi(String s) {
        char[] input = s.toCharArray();
        char[] number = new char[200];
        int len = input.length;
        int nlen = 0;
        int i;
        for (i = 0; i < len && input[i] == ' '; i++);
        if (i == len) {
            return 0;
        }
        if (!Character.isDigit(input[i]) && input[i] != '+' && input[i] != '-') {
            return 0;
        }
        number[nlen++] = input[i++];
        while (i < len) {
            if (Character.isDigit(input[i])) {
                number[nlen++] = input[i++];
            } else {
                break;
            }
        }
        if (number[nlen - 1] == '-' || number[nlen - 1] == '+') {
            return 0;
        }
        try {
            return Integer.parseInt(String.valueOf(number).substring(0, nlen));
        } catch (Exception e) {
            if (number[0] == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
