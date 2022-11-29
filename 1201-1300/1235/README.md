# [Maximum Profit in Job Scheduling](https://leetcode.com/problems/maximum-profit-in-job-scheduling/)

First sort the array by `startTime` in ascending order. Use `dp[i]` to represent the maximum profit when starting from `startTime[i]`. And `sn` is the first index of job whose `startTime` is greater than `startTime[i]` in array `list[i + 1], ..., list[length - 1]`, `en` is the first index of job whose `startTime` is greater than `endTime[i]` in array `list[i + 1], ..., list[length - 1]`. So the state transition equation is `dp[i] = Math.max(profit[i] + dp[en], dp[sn])`.

## code

```java
/**
 * 92 ms, 69.9 MB
 */
class Solution {
    private static class Node {
        int startTime;
        int endTime;
        int profit;
        public Node(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
        public int getStartTime() {
            return this.startTime;
        }
    }

    private int bsearchfge(Node[] list, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (list[mid].startTime >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int length = startTime.length;
        Node[] list = new Node[length];
        for (int i = 0; i < length; i++) {
            list[i] = new Node(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(list, Comparator.comparing(Node::getStartTime));
        int[] dp = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                dp[i] = list[i].profit;
                continue;
            }
            int sn = bsearchfge(list, i + 1, length, list[i].startTime);
            int en = bsearchfge(list, i + 1, length, list[i].endTime);
            int ev = en == length ? 0 : dp[en];
            dp[i] = Math.max(list[i].profit + ev, dp[sn]);
        }
        return dp[0];
    }
}
```
