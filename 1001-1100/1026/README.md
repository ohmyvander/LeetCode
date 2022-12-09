# [Maximum Difference Between Node and Ancestor](https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/)

Similar problem.

## code

```typescript
/**
 * 1 ms, 42.4 MB
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

    private void dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        result = Math.max(result, max - min);
        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }

    public int maxAncestorDiff(TreeNode root) {
        result = 0;
        dfs(root, root.val, root.val);
        return result;
    }
}
```
