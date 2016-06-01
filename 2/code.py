# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        node = ListNode(None)
        retNode = node
        carry = 0
        dig = 0
        flag = 0
        while l1 is not None and l2 is not None:
            if flag != 0:
                node.next = ListNode(None)
                node = node.next
            tmp = l1.val + l2.val + carry
            carry = tmp / 10
            dig = tmp % 10
            node.val = dig
            l1 = l1.next
            l2 = l2.next
            flag += 1
        while l1 is not None:
            if flag != 0:
                node.next = ListNode(None)
                node = node.next
            tmp = l1.val + carry
            carry = tmp / 10
            dig = tmp % 10
            node.val = dig
            l1 = l1.next
            flag += 1
        while l2 is not None:
            if flag != 0:
                node.next = ListNode(None)
                node = node.next
            tmp = l2.val + carry
            carry = tmp / 10
            dig = tmp % 10
            node.val = dig
            l2 = l2.next
            flag += 1
        if carry != 0:
            node.next = ListNode(None)
            node = node.next
            node.val = carry
        return retNode