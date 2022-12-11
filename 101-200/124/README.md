# [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

dp on trees, the state transition equation is `dp[cur] = max(cur.val, cur.val + dp[cur.left], cur.val + dp[cur.right])`. Since we want to get the maximum path sum, two paths can be connected by a middle node. So we should additional consider `tempmax = max(cur.val, cur.val + dp[cur.left], cur.val + dp[cur.right], cur.val + dp[cur.left] + dp[cur.right])` when calculating the result.

## code

```java
/**
 * 1 ms, 48.3 MB
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

    private int dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            result = Math.max(result, node.val);
            return node.val;
        }
        int l = node.left == null ? 0 : dfs(node.left);
        int r = node.right == null ? 0 : dfs(node.right);
        int temp = Math.max(node.val, node.val + Math.max(l, r));
        result = Math.max(Math.max(result, temp), node.val + l + r);
        return temp;
    }

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }
}
```
