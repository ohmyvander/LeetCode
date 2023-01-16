# [Jump Game](https://leetcode.com/problems/jump-game/)

dfs.

## code

```java
/**
 * 400 ms, 69.9 MB
 */
class Solution {
    private boolean[] visited = new boolean[10050];
    
    public boolean dfs(int[] nums, int start) {
        visited[start] = true;
        boolean result = false;
        if (start == nums.length - 1) {
            return true;
        }
        for (int i = 1; i <= nums[start]; i++) {
            int left = start - i;
            int right = start + i;
            if (left >= 0 && !visited[left]) {
                result = dfs(nums, left);
            }
            if (!result && right < nums.length && !visited[right]) {
                result = dfs(nums, right);
            }
            if (result) {
                return true;
            }
        }
        return false;
    }
    
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }
}
```