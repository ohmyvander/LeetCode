# [Split Message Based on Limit](https://leetcode.com/problems/split-message-based-on-limit/)

At first I use binary search to find parts, and after get wrong answer result I realized it is a wrong method. Then I use brute force, traverse from 1 to the length of `message`.

## code

```java
/**
 * 129 ms, 50.5 MB
 */
class Solution {
    private int getSuffixLength(int num) {
        int d = String.valueOf(num).length();
        int result = 0;
        int temp = 0;
        int dig = 1;
        for (int i = 1; i < d; i++) {
            dig *= 10;
            result += (dig - 1 - temp) * i;
            temp = dig - 1;
        }
        result += (num - temp) * d;
        return result + 3 * num + d * num;
    }

    public String[] splitMessage(String message, int limit) {
        int l = 1;
        int length = message.length();
        int count = 0;
        for (l = 1; l <= length; l++) {
            int suffixLen = getSuffixLength(l);
            int total = length + suffixLen;
            count = (total + limit - 1) / limit;
            if (count == l) {
                break;
            }
        }
        if (l == length + 1) {
            return new String[] {};
        }
        String[] result = new String[count];
        int prev = 0;
        for (int i = 1; i <= l; i++) {
            String suffix = String.format("<%d/%d>", i, count);
            int strLen = limit - suffix.length();
            int end = prev + strLen;
            if (end > length) {
                end = length;
            }
            String temp = message.substring(prev, end) + suffix;
            result[i - 1] = temp;
            prev = end;
        }
        return result;
    }
}
```
