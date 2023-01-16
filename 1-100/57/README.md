# [Insert Interval](https://leetcode.com/problems/insert-interval/)

For loop.

## code

```java
/**
 * 4 ms, 44.9 MB
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int length = intervals.length;
        for (int i = 0; i < length; i++) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        list.add(new int[]{newInterval[0], newInterval[1]});
        list.add(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
        list.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        boolean insert = false;
        boolean merge = false;
        int istart = -1, iend = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];
            int nstart = list.get(i + 1)[0];
            int nend = list.get(i + 1)[1];
            if (merge) {
                if (nend < iend) {
                    continue;
                }
                merge = false;
                if (nstart > iend) {
                    insert = true;
                } else {
                    iend = nend;
                }
            } else {
                if (nstart > end) {
                    if (istart == -1) {
                        istart = start;
                    }
                    iend = end;
                    insert = true;
                } else {
                    istart = start;
                    iend = Math.max(end, nend);
                    merge = true;
                }
            }
            if (insert) {
                result.add(new int[]{istart, iend});
                istart = iend = -1;
                insert = false;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
```
