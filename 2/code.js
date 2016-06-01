/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    var node = new ListNode(),
        retNode = node,
        carry = 0,
        dig = 0,
        tmp, flag;
    function div(num1, num2) {
        num1 = Math.round(num1);
        num2 = Math.round(num2);
        var result = num1 / num2;
        if (result >= 0){
            result = Math.floor(result);
        } else {
            result = Math.ceil(result);
        }
        return result;
    }
    flag = 0;
    while (l1 !== null && l2 !== null) {
        if (flag !== 0) {
            node.next = new ListNode();
            node = node.next;
        }
        tmp = l1.val + l2.val + carry;
        carry = div(tmp, 10);
        dig = tmp % 10;
        node.val = dig;
        l1 = l1.next;
        l2 = l2.next;
        flag += 1;
    }
    while (l1 !== null) {
        if (flag !== 0) {
            node.next = new ListNode();
            node = node.next;
        }
        tmp = l1.val + carry;
        carry = div(tmp, 10);
        dig = tmp % 10;
        node.val = dig;
        l1 = l1.next;
        flag += 1;
    }
    while (l2 !== null) {
        if (flag !== 0) {
            node.next = new ListNode();
            node = node.next;
        }
        tmp = l2.val + carry;
        carry = div(tmp, 10);
        dig = tmp % 10;
        node.val = dig;
        l2 = l2.next;
        flag += 1;
    }
    if (carry !== 0) {
        node.next = new ListNode();
        node = node.next;
        node.val = carry;
    }
    return retNode;
};