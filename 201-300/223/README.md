# [Rectangle Area](https://leetcode.com/problems/rectangle-area/)

To by added....

## code

```java
/**
 * 6 ms, 43.6 MB
 */
class Solution {
    private int geta(int a, int b) {
        return a;
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if (ay2 > by2) {
            bx1 = geta(ax1, ax1 = bx1);
            by1 = geta(ay1, ay1 = by1);
            bx2 = geta(ax2, ax2 = bx2);
            by2 = geta(ay2, ay2 = by2);
        }
        if (ax2 <= bx1 || ay2 <= by1 || ax1 >= bx2) {
            return area;
        }
        int w = 0, h = 0;
        if (ax2 >= bx2 && ax1 >= bx1) {
            w = bx2 - ax1;
        } else if (ax2 <= bx2 && ax1 <= bx1) {
            w = ax2 - bx1;
        } else if (ax2 >= bx2 && ax1 <= bx1) {
            w = bx2 - bx1;
        } else if (ax2 <= bx2 && ax1 >= bx1) {
            w = ax2 - ax1;
        }
        if (ay1 >= by1) {
            h = ay2 - ay1;
        } else if (ay1 <= by1) {
            h = ay2 - by1;
        }
        return area - w * h;
    }
}
```
