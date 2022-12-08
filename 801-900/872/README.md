# [Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/)

Simple problem.

## code

```java
/**
 * 1 ms, 42.8 MB
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
    private void dfs(TreeNode node, List<Integer> nums) {
        if (node.left == null && node.right == null) {
            nums.add(node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, nums);
        }
        if (node.right != null) {
            dfs(node.right, nums);
        }
    } 

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        dfs(root1, nums1);
        dfs(root2, nums2);
        if (nums1.size() != nums2.size()) {
            return false;
        }
        for (int i = 0; i < nums1.size(); i++) {
            if (!nums1.get(i).equals(nums2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
```
