# [Count Subarrays With Median K](https://leetcode.com/problems/count-subarrays-with-median-k/)

First, find the index `pos` of `k` in array `nums`. If `k` is the middle element of an array, set all elements to `-1` which are less than `k`, and set all elements to `1` which are greater than `k`. So the sum of array must be `0` or `1`. Use `trans` to represent the sum between `nums[i]` and `nums[pos]`, or `nums[pos]` and `nums[j]` when all numbers are transfered to `1` or `-1`. For example:

```
nums:  [3,2,1,4,5]
trans: [-3,-2,-1,0,1]
```

Sorting `nums` from index `pos + 1` to `length - 1`, then do a for loop from index `pos - 1` to `0`, for each `trans[i]`, we can use binary search to find count of number when `trans[i] + number == 0` or `trans[i] + number == 1`.

## code

```java
/**
 * 66 ms, 73.2 MB
 */
class Solution {
    private int bsearchL(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l < nums.length && nums[l] == target ? l : -1;
    }
    
    private int bsearchR(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return --l >= 0 && nums[l] == target ? l : -1;
    }
    
    public int countSubarrays(int[] nums, int k) {
        int length = nums.length;
        int pos = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == k) {
                pos = i;
                break;
            }
        }
        int[] trans = new int[length];
        trans[pos] = 0;
        for (int i = pos + 1; i < length; i++) {
            if (nums[i] > k) {
                trans[i] = trans[i - 1] + 1;
            } else {
                trans[i] = trans[i - 1] - 1;
            }
        }
        for (int i = pos - 1; i>= 0; i--) {
            if (nums[i] > k) {
                trans[i] = trans[i + 1] + 1;
            } else {
                trans[i] = trans[i + 1] - 1;
            }
        }
        Arrays.sort(trans, pos + 1, length);
        int result = 0;
        for (int i = pos; i >= 0; i--) {
            if (trans[i] == 0 || trans[i] == 1) {
                result++;
            }
            int temp = 0 - trans[i];
            int left, right;
            left = bsearchL(trans, pos + 1, length, temp);
            if (left != -1) {
                right = bsearchR(trans, pos + 1, length, temp);
                result += right - left + 1;
            }
            temp = 1 - trans[i];
            left = bsearchL(trans, pos + 1, length, temp);
            if (left != -1) {
                right = bsearchR(trans, pos + 1, length, temp);
                result += right - left + 1;
            }
        }
        return result;
    }
}
```
