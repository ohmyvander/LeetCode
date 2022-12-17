# [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

Simple problem.

## code

```java
/**
 * 6 ms, 41.9 MB
 */
class Solution {
    private Stack<Long> stack;

    public int evalRPN(String[] tokens) {
        stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                long b = stack.pop();
                long a = stack.pop();
                long temp = 0;
                if (str.equals("+")) {
                    temp = a + b;
                } else if (str.equals("-")) {
                    temp = a - b;
                } else if (str.equals("*")) {
                    temp = a * b;
                } else {
                    temp = a / b;
                }
                stack.push(temp);
            } else {
                stack.push(Long.parseLong(str));
            }
        }
        return (int) stack.pop().longValue();
    }
}
```
