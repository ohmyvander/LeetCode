# [Basic Calculator](https://leetcode.com/problems/basic-calculator/)

Solution one, use stack to handle string.
Solution two, use ast tree. To be added....

## code

```java
/**
 * Solution one
 * 103 ms, 55.5 MB
 */
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        s = s + "#";
        Stack<String> stack = new Stack<>();
        stack.push("0");
        int cnt = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                temp += ch;
            } else if (ch == '+' || ch == '-') {
                if ("".equals(temp)) {
                    temp = "0";
                }
                String top = stack.pop();
                int num = Integer.parseInt(top) + Integer.parseInt(temp);
                stack.push(String.valueOf(num));
                temp = String.valueOf(ch);
            } else if (ch == '(') {
                if ("".equals(temp)) {
                    temp = "+";
                }
                stack.push(temp);
                stack.push("0");
                temp = "";
            } else if (ch == ')') {
                if ("".equals(temp)) {
                    temp = "0";
                }
                int num = Integer.parseInt(temp);
                while (!stack.isEmpty()) {
                    String top = stack.pop();
                    if ("+".equals(top) || "-".equals(top)) {
                        int mark = "+".equals(top) ? 1 : -1;
                        stack.push(String.valueOf(mark * num));
                        break;
                    } else {
                        num += Integer.parseInt(top);
                    }
                }
                temp = "";
            } else if (ch == '#') {
                if ("".equals(temp)) {
                    temp = "0";
                }
                stack.push(temp);
            }
        }
        int num = 0;
        while (!stack.isEmpty()) {
            String str = stack.pop();
            num += Integer.parseInt(str);
        }
        return num;
    }
}
```
