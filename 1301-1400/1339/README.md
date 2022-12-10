# [Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/)

Simple problem.

## code

```java
/**
 * 38 ms, 76.9 MB
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
    private int dfs(TreeNode node, List<Integer> sums) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            sums.add(node.val);
            return node.val;
        }
        int sum = node.val + dfs(node.left, sums) + dfs(node.right, sums);
        sums.add(sum);
        return sum;
    }

    public int maxProduct(TreeNode root) {
        int mod = (int) 1e9 + 7;
        List<Integer> sums = new ArrayList<>();
        dfs(root, sums);
        int total = sums.get(sums.size() - 1);
        long result = 0;
        for (int i = 0; i < sums.size() - 1; i++) {
            result = Math.max(result, (long) sums.get(i) * (total - sums.get(i)));
        }
        return (int) (result % mod);
    }
}
```
