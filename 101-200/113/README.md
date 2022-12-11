# [Path Sum II](https://leetcode.com/problems/path-sum-ii/)

Simple problem.

## code

```java
/**
 * 3 ms, 45.5 MB
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
    private List<List<Integer>> result;
    private Stack<Integer> stack;

    private void dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return;
        }
        int curSum = node.val + sum;
        stack.push(node.val);
        if (node.left == null && node.right == null) {
            if (curSum == targetSum) {
                result.add(new ArrayList<>(stack));
            }
            stack.pop();
            return;
        }
        dfs(node.left, curSum, targetSum);
        dfs(node.right, curSum, targetSum);
        stack.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        stack = new Stack<>();
        dfs(root, 0, targetSum);
        return result;
    }
}
```

```java
/**
 * 5 ms, 47.1 MB
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
    private List<List<Integer>> result;
    private Integer[] stack;
    private int top;

    private void dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return;
        }
        int curSum = node.val + sum;
        stack[top++] = node.val;
        if (node.left == null && node.right == null) {
            if (curSum == targetSum) {
                result.add(new ArrayList<>(Arrays.asList(Arrays.copyOf(stack, top))));
            }
            top--;
            return;
        }
        dfs(node.left, curSum, targetSum);
        dfs(node.right, curSum, targetSum);
        top--;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        stack = new Integer[5005];
        top = 0;
        dfs(root, 0, targetSum);
        return result;
    }
}
```
