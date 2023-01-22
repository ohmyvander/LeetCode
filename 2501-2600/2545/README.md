# [Sort the Students by Their Kth Score](https://leetcode.com/problems/sort-the-students-by-their-kth-score/)

Simple problem.

## code

```java
/**
 * 4 ms, 52.5 MB
 */
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, Comparator.comparingInt(a -> -a[k]));
        return score;
    }
}
```
