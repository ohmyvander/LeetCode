# [Subsets](https://leetcode.com/problems/subsets/)

The first time I used dfs to solve it, but the performance was bad. After reading other solutions, I realized that each subset could be represented a bitmask of length `n`.

## code

```java
/**
 * dfs
 * 1653 ms, 144.6 MB
 */
class Solution {
    private int[] posNum = new int[20];
    private boolean[] visited = new boolean[5000];
    
    private List<Integer> listMap(int[] nums, int status) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((status & posNum[i]) == posNum[i]) {
                result.add(nums[i]);
            }
        }
        return result;
    }
    
    public List<List<Integer>> dfs(int[] nums, int status, int left) {
        List<List<Integer>> result = new ArrayList<>();
        if (left == 0) {
            if (!visited[status]) {
                result.add(listMap(nums, status));
                visited[status] = true;
            }
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((status & posNum[i]) == 0) {
                result.addAll(dfs(nums, status | posNum[i], left - 1));
            }
        }
        return result;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        posNum[0] = 1;
        for (int i = 1; i < 11; i++) {
            posNum[i] = 2 * posNum[i - 1];
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            result.addAll(dfs(nums, 0, i));
        }
        return result;
    }
}
```

```java
/**
 * bitmask
 * 0 ms, 42.4 MB
 */
class Solution {
    private List<Integer> listMap(int[] nums, int status) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pos = 1 << (nums.length - 1 - i);
            if ((status & pos) == pos) {
                result.add(nums[i]);
            }
        }
        return result;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        int max = nums.length == 0 ? 0 : (1 << nums.length);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            result.add(listMap(nums, i));
        }
        return result;
    }
}
```