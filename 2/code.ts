/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */
/**
 * 字符串处理，两个正整数相加求和。正整数用链表倒序表示
 * 
 * 字符串处理
 * 
 * 156 ms, 44.8 MB
 * 
 * @param l1 数字1
 * @param l2 数字1
 * @returns 结果
 */
function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    const result: ListNode = new ListNode();
    let current = result;
    let carry = 0;
    while (l1 || l2) {
        current.next = new ListNode();
        current = current.next;
        const temp = (l1 ? l1.val : 0) + (l2 ? l2.val : 0) + carry;
        current.val = temp % 10;
        carry = Math.floor(temp / 10);
        l1 = l1 && l1.next;
        l2 = l2 && l2.next;
    }
    current.next = carry ? new ListNode(carry) : null;
    return result.next;
};
