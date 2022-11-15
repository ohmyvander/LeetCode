# [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

Simple dfs.

## code

```java
/**
 * 1 ms, 49.6 MB
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
    private int result;

    private void dfs(TreeNode node) {
        if (node.left != null) {
            result++;
            dfs(node.left);
        }
        if (node.right != null) {
            result++;
            dfs(node.right);
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result + 1;
    }
}
```
