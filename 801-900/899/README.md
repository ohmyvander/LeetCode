# [Orderly Queue](https://leetcode.com/problems/orderly-queue/)

When `k > 1`, just return the sorted string. If `k = 1`, we need to rotate the string to find the lexicographically smallest one. Can not be a hard problem....

## code

```java
/**
 * 13 ms, 45.7 MB
 */
class Solution {
    public String orderlyQueue(String s, int k) {
        if (k >= 2) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            return new String(chs);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i, s.length()) + s.substring(0, i));
        }
        list.sort(null);
        return list.get(0);
    }
}
```

```java
/**
 * 7 ms, 44.9 MB
 */
class Solution {
    public String orderlyQueue(String s, int k) {
        if (k >= 2) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            return new String(chs);
        }
        String result = s;
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, s.length()) + s.substring(0, i);
            if (result.compareTo(temp) > 0) {
                result = temp;
            }
        }
        return result;
    }
}
```
