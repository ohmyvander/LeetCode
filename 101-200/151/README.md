# [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

Simple problem.

## code

```java
/**
 * 12 ms, 44.8 MB
 */
class Solution {
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.trim().replaceAll(" +", " ").split(" "));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
```
