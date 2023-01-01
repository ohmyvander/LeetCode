# [Minimum Number of Operations to Sort a Binary Tree by Level](https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/)

Solution one, bubble sort.

Solution two, use a `map` to record the index of each number, and `sorted` to store the right order of numbers in every level. Then swap numbers.

## code

```java
/**
 * solution one
 * 1773 ms, 81.1 MB
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
    private Map<Integer, List<Integer>> map;

    private void dfs(TreeNode cur, int depth) {
        if (cur == null) {
            return;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, new ArrayList<>());
        }
        map.get(depth).add(cur.val);
        dfs(cur.left, depth + 1);
        dfs(cur.right, depth + 1);
    }

    public int minimumOperations(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 1);
        Set<Integer> keys = map.keySet();
        int result = 0;
        for (Integer key : keys) {
            int[] arr = map.get(key).stream().mapToInt(Integer::intValue).toArray();
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                int mi = i;
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] < arr[mi]) {
                        mi = j;
                    }
                }
                if (mi != i) {
                    result++;
                    int temp = arr[mi];
                    arr[mi] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return result;
    }
}
```

```java
/**
 * solution two
 * 66 ms, 58.7 MB
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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            int[] sorted = new int[length];
            int[] arr = new int[length];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                sorted[i] = node.val;
                arr[i] = node.val;
                map.put(node.val, i);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            Arrays.sort(sorted);
            for (int i = 0; i < length; i++) {
                if (map.get(sorted[i]).intValue() == i) {
                    continue;
                }
                int idx = map.get(sorted[i]);
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                map.put(arr[idx], idx);
                result++;
            }
        }
        return result;
    }
}
```
