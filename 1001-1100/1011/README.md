# [Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)

`sum[i]` is the sum of array `weights[0], ..., weights[i]`, then do binary search.

## code

```java
/**
 * increase capacity, then binary search sum array
 * 2335 ms, 54.2 MB
 */
class Solution {
    private int bsearchle(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return --l;
    }

    public int shipWithinDays(int[] weights, int days) {
        int length = weights.length;
        int[] sum = new int[length + 1];
        sum[0] = 0;
        sum[1] = weights[0];
        for (int i = 1; i < length; i++) {
            sum[i + 1] = sum[i] + weights[i];
        }
        length++;
        int start = sum[length - 1] / days;
        if (days == 1) {
            return start;
        }
        int idx = 0;
        while (true) {
            for (; idx < length && sum[idx] <= start; idx++) {}
            if (idx == length) {
                return start;
            }
            int day = 1;
            int prev = sum[--idx];
            int nIdx = idx;
            while (++day <= days) {
                int next = prev + start;
                nIdx = bsearchle(sum, nIdx + 1, length, next);
                if (nIdx == length - 1) {
                    return start;
                }
                prev = sum[nIdx];
            }
            start++;
        }
    }
}
```

```java
/**
 * binary search capacity, then binary search sum array
 * 87 ms, 45.8 MB
 */
class Solution {
    private int bsearchle(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return --l;
    }

    public int shipWithinDays(int[] weights, int days) {
        int length = weights.length;
        int[] sums = new int[length];
        sums[0] = weights[0];
        for (int i = 1; i < length; i++) {
            sums[i] = sums[i - 1] + weights[i];
        }
        int l = 1, r = sums[length - 1] + 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int day = 1;
            int pstart = 0;
            int psum = 0;
            boolean less = false;
            while (day <= days) {
                int start = bsearchle(sums, pstart, length, psum + mid);
                if (start < pstart) {
                    less = false;
                    break;
                }
                if (start == length - 1) {
                    less = true;
                    break;
                }
                psum = sums[start];
                pstart = start + 1;
                day++;
            }
            if (less) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```

```java
/**
 * binary search capacity, then for loop sum array
 * 16 ms, 54.6 MB
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int length = weights.length;
        int[] sums = new int[length];
        sums[0] = weights[0];
        for (int i = 1; i < length; i++) {
            sums[i] = sums[i - 1] + weights[i];
        }
        int l = 1, r = sums[length - 1] + 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int psum = 0;
            int pidx = -1;
            int day = 0;
            boolean less = false;
            for (int i = 0; i < length && day < days; i++) {
                if (sums[i] > psum + mid) {
                    if (pidx == i - 1) {
                        less = false;
                        break;
                    } else {
                        pidx = --i;
                        psum = sums[pidx];
                        day++;
                    }
                }
                if (i == length - 1) {
                    less = true;
                }
            }
            if (less) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```
