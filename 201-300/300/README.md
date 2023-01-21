# [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

Use `list[i]` to store the minimum number when the length of strictly increasing subsequence is `i + 1`, and `list` must be sorted in increasing order. So the answer is the length of `list`.

## code

```java
/**
 * 5 ms, 41.4 MB
 */
class Solution {
    private int bsearchge(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) == target) {
                return mid;
            }
            if (target > list.get(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < length; i++) {
            int idx = bsearchge(list, nums[i]);
            if (idx == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(idx, nums[i]);
            }
        }
        return list.size();
    }
}
```
