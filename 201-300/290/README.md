# [Word Pattern](https://leetcode.com/problems/word-pattern/)

Simple problem.

## code

```java
/**
 * 1 ms, 40.4 MB
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        int pLen = pattern.length();
        int sLen = strs.length;
        if (pLen != sLen) {
            return false;
        }
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char ch = pattern.charAt(i);
            String str = map1.getOrDefault(ch, strs[i]);
            Character c = map2.getOrDefault(strs[i], ch);
            if (!str.equals(strs[i]) || !c.equals(ch)) {
                return false;
            }
            map1.put(ch, strs[i]);
            map2.put(strs[i], ch);
        }
        return true;
    }
}
```
