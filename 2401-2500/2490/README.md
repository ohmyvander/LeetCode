# [Circular Sentence](https://leetcode.com/problems/circular-sentence/)

Simple problem.

## code

```java
/**
 * 2 ms, 43.2 MB
 */
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int length = words.length;
        for (int i = 0; i < length; i++) {
            int nexti = i + 1;
            if (nexti == length) {
                nexti = 0;
            }
            if (words[i].charAt(words[i].length() - 1) != words[nexti].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
```
