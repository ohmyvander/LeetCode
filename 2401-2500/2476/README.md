# [Closest Nodes Queries in a Binary Search Tree](https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/)

Simple problem.

## code

```java
/**
 * 128 ms, 167.7 MB
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int[] nums;
    private int cnt;
    
    private void travel(TreeNode node) {
        if (node == null) {
            return;
        }
        nums[cnt++] = node.val;
        travel(node.left);
        travel(node.right);
    }
    
    private List<Integer> bSearch(int num) {
        int l = 0;
        int r = cnt;
        List<Integer> result = new ArrayList<>();
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == num) {
                result.add(num);
                result.add(num);
                return result;
            } else if (nums[mid] > num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == 0) {
            result.add(-1);
            result.add(nums[l]);
        } else if (l == cnt) {
            if (nums[l - 1] < num) {
                result.add(nums[l - 1]);
                result.add(-1);
            } else {
                result.add(nums[l - 2]);
                result.add(nums[l - 1]);
            }
        } else {
            result.add(nums[l - 1]);
            result.add(nums[l]);
        }
        return result;
    }
    
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        nums = new int[100050];
        cnt = 0;
        travel(root);
        Arrays.sort(nums, 0, cnt);
        List<List<Integer>> result = new ArrayList<>();
        for (Integer query : queries) {
            result.add(bSearch(query));
        }
        return result;
    }
}
```

```java
/**
 * 1371 ms, 164 MB
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        for (Integer query : queries) {
            TreeNode cur = root;
            int min = -1, max = -1;
            List<Integer> temp = new ArrayList<>();
            while (true) {
                if (cur.val == query) {
                    temp.add(query);
                    temp.add(query);
                    result.add(temp);
                    break;
                } else if (cur.val > query) {
                    max = cur.val;
                    cur = cur.left;
                } else {
                    min = cur.val;
                    cur = cur.right;
                }
                if (cur == null) {
                    temp.add(min);
                    temp.add(max);
                    result.add(temp);
                    break;
                }
            }
        }
        return result;
    }
}
```
