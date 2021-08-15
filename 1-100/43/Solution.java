/**
 * 字符串模拟大数相乘
 *
 * 30 ms, 44.4 MB
 */
class Solution {
    private static final String ZERO = "0";

    private String digitalMultiply(String num, int digit, int pos) {
        char[] chars = new char[pos];
        Arrays.fill(chars, '0');
        StringBuilder result = new StringBuilder(new String(chars));
        int over = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            int calc = digit * d + over;
            int cur = calc % 10;
            over = calc / 10;
            result.append(cur);
        }
        if (over != 0) {
            result.append(over);
        }
        return result.toString();
    }

    private String add(String num1, String num2) {
        int over = 0;
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int d1 = i < num1.length() ? num1.charAt(i) - '0' : 0;
            int d2 = i < num2.length() ? num2.charAt(i) - '0' : 0;
            int calc = d1 + d2 + over;
            int cur = calc % 10;
            over = calc / 10;
            result.append(cur);
        }
        if (over != 0) {
            result.append(over);
        }
        return result.toString();
    }

    public String multiply(String num1, String num2) {
        if (ZERO.equals(num1) || ZERO.equals(num2)) {
            return ZERO;
        }
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String number = digitalMultiply(num1, num2.charAt(i) - '0', num2.length() - 1 - i);
            result = add(result, number);
        }
        return new StringBuffer(result).reverse().toString();
    }
}

