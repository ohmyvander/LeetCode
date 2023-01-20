# [Non-decreasing Subsequences](https://leetcode.com/problems/non-decreasing-subsequences/)

Use a list to store each subsequence and change the list when doing dfs.

```java
/**
 * 5 ms, 47.8 MB
 */
class Solution {
    private List<List<Integer>> result;
    private List<Integer> sequence;

    private void dfs(int cur, int[] nums) {
        if (sequence.size() > 1) {
            result.add(new ArrayList<>(sequence));
        }
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        int ssize = sequence.size();
        int num = ssize == 0 ? Integer.MIN_VALUE : sequence.get(ssize - 1);
        for (int i = cur; i < length; i++) {
            if (set.contains(nums[i]) || nums[i] < num) {
                continue;
            }
            set.add(nums[i]);
            sequence.add(nums[i]);
            dfs(i + 1, nums);
            sequence.remove(ssize);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        sequence = new ArrayList<>();
        dfs(0, nums);
        return result;
    }
}
```
