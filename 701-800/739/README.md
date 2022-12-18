# [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

Use monotonous stack, save the `temperature` which does not get the answer temporarily in stack. At last the answer of all temperatures in stack are `0`.

```java
/**
 * 149 ms, 54.5 MB
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        stack.push(0);
        int[] result = new int[length];
        for (int i = 1; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}
```
