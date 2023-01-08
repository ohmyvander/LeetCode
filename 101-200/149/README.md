# [Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/)

Brute force and use map to optimize.

## code

```java
/**
 * 10 ms, 39.7 MB
 */
class Solution {
    private boolean[][] visited;

    public int maxPoints(int[][] points) {
        int length = points.length;
        if (length == 1) {
            return 1;
        }
        int[] line = new int[length];
        visited = new boolean[length][length];
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                cnt = 0;
                line[cnt++] = i;
                line[cnt++] = j;
                int x1 = points[j][0] - points[i][0];
                int y1 = points[j][1] - points[i][1];
                for (int k = j + 1; k < length; k++) {
                    int x2 = points[k][0] - points[i][0];
                    int y2 = points[k][1] - points[i][1];
                    if (x1 * y2 - x2 * y1 == 0) {
                        line[cnt++] = k;
                    }
                }
                result = Math.max(result, cnt);
                for (int m = 0; m < cnt; m++) {
                    for (int n = m + 1; n < cnt; n++) {
                        visited[line[m]][line[n]] = true;
                    }
                }
            }
        }
        return result;
    }
}
```
