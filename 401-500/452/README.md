# [Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)

Sort points by `xstart` in increasing order, and then `xend` in increasing order. Then use greedy algorithm, set `tend = points[0][1]`, and traverse `points`. If `points[i][1] < tend`, then set `tend = points[i][1]`. If `points[i][0] > tend`, then add one to result and set `tend = points[i][1]`.

## code

```java
/**
 * 70 ms, 79.8 MB
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int result = 1;
        int length = points.length;
        int tend = points[0][1];
        for (int i = 1; i < length; i++) {
            if (points[i][1] < tend) {
                tend = points[i][1];
            } else if (points[i][0] > tend) {
                tend = points[i][1];
                result++;
            }
        }
        return result;
    }
}
```