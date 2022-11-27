# [Two Best Non-Overlapping Events](https://leetcode.com/problems/two-best-non-overlapping-events/)

First sort the array by `startTime` in ascending order. Then use an array `maxVal` to record the possible maximum value of each event. For example, after sorting `events`, we can get `events[i].startTime <= events[i + 1].startTime`. If `events[i].value < events[i + 1].value`, then `maxVal[i] = events[i + 1].value`. After get `maxVal`, we can do binary search to get the maximum score of an interval not intersecting with the interval we choose.

## code

```java
/**
 * 81 ms, 115.3 MB
 */
class Solution {
    private static class Node {
        public int start;
        public int end;
        public int value;
        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
        public int getStart() {
            return this.start;
        }
    }

    private int bsearchge(Node[] list, int target, int[] maxVal) {
        int l = 0;
        int r = list.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list[mid].start >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l == list.length ? 0 : maxVal[l];
    }

    public int maxTwoEvents(int[][] events) {
        int length = events.length;
        Node[] list = new Node[length];
        for (int i = 0; i < length; i++) {
            list[i] = new Node(events[i][0], events[i][1], events[i][2]);
        }
        Arrays.sort(list, Comparator.comparing(Node::getStart));
        int[] maxVal = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            maxVal[i] = Math.max(list[i].value, i == length - 1 ? 0 : maxVal[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, list[i].value + bsearchge(list, list[i].end + 1, maxVal));
        }
        return result;
    }
}
```
