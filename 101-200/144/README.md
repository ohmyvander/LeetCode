# [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)

Preorder traversal.

## code

```java
/**
 * 0 ms, 40.8 MB
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
    private List<Integer> result;

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        dfs(root);
        return result;
    }
}
```
