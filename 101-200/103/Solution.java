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

/**
 * 按从右到左，从左到右，再从右到左...以此类推的顺序输出树的每一层的元素
 *
 * 1 ms, 39.1 MB
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean reverse = false;
        TreeNode[][] queue = new TreeNode[2][];
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int idx = 0;
        queue[idx] = new TreeNode[1];
        queue[idx][0] = root;
        int cnt = 1;
        while (cnt != 0) {
            List<Integer> row = new ArrayList<>();
            int nIdx = 1 - idx;
            queue[nIdx] = new TreeNode[2000];
            int nCnt = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode treeNode = queue[idx][i];
                row.add(treeNode.val);
                if (treeNode.left != null) {
                    queue[nIdx][nCnt++] = treeNode.left;
                }
                if (treeNode.right != null) {
                    queue[nIdx][nCnt++] = treeNode.right;
                }
            }
            if (reverse) {
                Collections.reverse(row);
            }
            result.add(row);
            idx = 1 - idx;
            reverse = !reverse;
            cnt = nCnt;
        }
        return result;
    }
}
