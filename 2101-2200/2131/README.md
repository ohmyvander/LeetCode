# [Longest Palindrome by Concatenating Two Letter Words](https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/)

Simple problem, using map and for loop.

## code

```java
/**
 * 286 ms, 126.6 MB
 */
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>(16);
        int length = words.length;
        int result = 0;
        for (String str : words) {
            String temp = new StringBuilder(str).reverse().toString();
            if (!map.containsKey(temp)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            } else {
                int count = map.get(temp);
                if (count > 0) {
                    result += 4;
                    map.put(temp, count - 1);
                } else {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int count = entry.getValue();
            if (str.charAt(0) == str.charAt(1) && count == 1) {
                result += 2;
                break;
            }
        }
        return result;
    }
}
```
