# [Delete Columns to Make Sorted](https://leetcode.com/problems/delete-columns-to-make-sorted/)

Simple problem.

## code

```java
/**
 * 26 ms, 47.6 MB
 */
class Solution {
    public int minDeletionSize(String[] strs) {
        int length = strs.length;
        int size = strs[0].length();
        int result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < length; j++) {
                char a = strs[j - 1].charAt(i);
                char b = strs[j].charAt(i);
                if (a > b) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
```
