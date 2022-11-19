# [Erect the Fence](https://leetcode.com/problems/erect-the-fence/)

Computational geometry, calculate all point on a convex hull. Use graham scan algorithm. Reverse last line point in array.

## code

```java
/**
 * 52 ms, 54.8 MB
 */
class Solution {
    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int crossProduct(Point p0, Point p1, Point p2) {
        int x1 = p1.x - p0.x;
        int y1 = p1.y - p0.y;
        int x2 = p2.x - p0.x;
        int y2 = p2.y - p0.y;
        return x1 * y2 - x2 * y1;
    }

    private int distance2(Point p1, Point p2) {
        int w = p2.x - p1.x;
        int h = p2.y - p1.y;
        return w * w + h * h;
    }

    private int[][] grahamScan(Point[] plist) {
        int length = plist.length;
        Point[] convexHull = new Point[length];
        int cnt = 0;
        convexHull[cnt++] = plist[0];
        convexHull[cnt++] = plist[1];
        for (int i = 2; i < length; i++) {
            while (cnt >= 2 && crossProduct(convexHull[cnt - 2], convexHull[cnt - 1], plist[i]) < 0) {
                cnt--;
            }
            convexHull[cnt++] = plist[i];
        }
        int[][] result = new int[cnt][];
        for (int i = 0; i < cnt; i++) {
            result[i] = new int[2];
            result[i][0] = convexHull[i].x;
            result[i][1] = convexHull[i].y;
        }
        return result;
    }

    public int[][] outerTrees(int[][] trees) {
        int length = trees.length;
        if (length <= 2) {
            return trees;
        }
        Point[] plist = new Point[length];
        int yMin = Integer.MAX_VALUE, xMin = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < length; i++) {
            plist[i] = new Point(trees[i][0], trees[i][1]);
            if (plist[i].y < yMin || plist[i].y == yMin && plist[i].x < xMin) {
                idx = i;
                yMin = plist[i].y;
                xMin = plist[i].x;
            }
        }
        Point temp = plist[idx];
        plist[idx] = plist[0];
        plist[0] = temp;
        Arrays.sort(plist, 1, length, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int cross = crossProduct(plist[0], p1, p2);
                if (cross > 0) {
                    return -1;
                } else if (cross < 0) {
                    return 1;
                } else {
                    int dist1 = distance2(plist[0], p1);
                    int dist2 = distance2(plist[0], p2);
                    return dist1 - dist2;
                }
            }
        });
        int k;
        for (k = length - 2; k >= 1; k--) {
            if (crossProduct(plist[0], plist[k], plist[k + 1]) != 0) {
                break;
            }
        }
        for (int i = k + 1, j = length - 1; i < j; i++, j--) {
            temp = plist[i];
            plist[i] = plist[j];
            plist[j] = temp;
        }
        return grahamScan(plist);
    }
}
```
