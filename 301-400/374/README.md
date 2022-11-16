# [Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)

Binary search.

## code

```java
/**
 * 0 ms, 41 MB
 */
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long l = 1;
        long r = n;
        int mid = (int) ((l + r) / 2);
        int compare;
        while ((compare = guess(mid)) != 0) {
            if (compare == 1) {
                l = mid + 1;
            } else {
                r = mid;
            }
            mid = (int) ((l + r) / 2);
        }
        return mid;
    }
}
```
