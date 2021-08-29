/**
 * 输入一个int数，输出对应的倒序数字，若超出int界限则输出0
 * 
 * 利用Integer.parseInt和try catch实现
 * 
 * 3 ms, 38.2 MB
 */
class Solution {
    public int reverse(int x) {
        char[] number = String.valueOf(x).toCharArray();
        int len = number.length;
        int start = 0;
        int end = (len + 1) / 2 - 1;
        if (number[0] == '-') {
            start = 1;
            end = len / 2;
        }
        for (int i = start; i <= end; i++) {
            int tIdx = len - 1 - i + start;
            char temp = number[i];
            number[i] = number[tIdx];
            number[tIdx] = temp;
        }
        String str = String.valueOf(number);
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }
}
