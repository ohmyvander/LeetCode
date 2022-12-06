# [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)

Simple problem.

## code

```java
/**
 * 3 ms, 45.5 MB
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
    public ListNode oddEvenList(ListNode head) {
        int count = 1;
        ListNode odd = new ListNode();
        ListNode startOdd = odd;
        ListNode even = new ListNode();
        ListNode startEven = even;
        while (head != null) {
            if (count % 2 == 1) {
                odd.next = new ListNode(head.val);
                odd = odd.next;
            } else {
                even.next = new ListNode(head.val);
                even = even.next;
            }
            head = head.next;
            count++;
        }
        odd.next = startEven.next;
        return startOdd.next;
    }
}
```
