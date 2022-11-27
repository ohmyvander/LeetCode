# [Remove Nodes From Linked List](https://leetcode.com/problems/remove-nodes-from-linked-list/)

Simple problem, use monotonous stack.

## code

```java
/**
 * 19 ms, 145.8 MB
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        int[] stack = new int[100005];
        int top = 0;
        while (head != null) {
            int val = head.val;
            while (top > 0 && stack[top - 1] < val) {
                top--;
            }
            stack[top++] = val;
            head = head.next;
        }
        ListNode next = null;
        ListNode node = null;
        for (int i = top - 1; i >= 0; i--) {
            node = new ListNode(stack[i], next);
            next = node;
        }
        return node;
    }
}
```
