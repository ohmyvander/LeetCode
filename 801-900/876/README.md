# [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)

Simple problem.

## code

```java
/**
 * 0 ms, 40 MB
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
    public ListNode middleNode(ListNode head) {
        ListNode[] nodes = new ListNode[200];
        int count = 0;
        while (head != null) {
            nodes[count++] = head;
            head = head.next;
        }
        return nodes[count / 2];
    }
}
```
