# [Total Cost to Hire K Workers](https://leetcode.com/problems/total-cost-to-hire-k-workers/)

Using a min-heap to get the minimum item.

## code

```java
/**
 * 1086 ms, 126.4 MB
 */
class Solution {
    static class Node {
        public int i;
        public int value;
        public Node(int i, int value) {
            this.i = i;
            this.value = value;
        }
        public int getI() {
            return this.i;
        }
        public int getValue() {
            return this.value;
        }
    }
    
    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getValue).thenComparing(Node::getI));
        int length = costs.length;
        int l, r;
        for (l = 0; l < length && l < candidates; l++) {
            queue.add(new Node(l, costs[l]));
        }
        for (r = length - 1; r >= 0 && r >= length - candidates && r >= l; r--) {
            queue.add(new Node(r, costs[r]));
        }
        long result = 0;
        for (int n = 0; n < k; n++) {
            Node node = queue.remove();
            result += node.value;
            if (l <= r) {
                if (node.i < l) {
                    queue.add(new Node(l, costs[l++]));
                } else {
                    queue.add(new Node(r, costs[r--]));
                }
            }
        }
        return result;
    }
}
```
