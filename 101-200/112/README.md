# [Path Sum](https://leetcode.com/problems/path-sum/)

Simple problem.

## code

```java
/**
 * 0 ms, 42 MB
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
    private boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (sum + node.val == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        boolean result = dfs(node.left, node.val + sum, targetSum);
        if (!result) {
            result = dfs(node.right, node.val + sum, targetSum);
        }
        return result;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
}
```

```java
/**
 * 1 ms, 43.6 MB
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
    private boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        int curSum = sum + node.val;
        if (node.left == null && node.right == null) {
            if (curSum == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        return dfs(node.left, curSum, targetSum) || dfs(node.right, curSum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
}
```
