# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from utils import ListNode


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = l1
        carry = 0
        while l1 or l2:
            if l1 and l2:
                l1.val = (l1.val + l2.val + carry) % 10
                carry = (l1.val + l2.val + carry) // 10
                l1 = l1.next
                l2 = l2.next

            if l1:
                l1.val = (l1.val + carry) % 10
                carry = (l1.val + carry) // 10

            if l2:
                l1.next = l2

        return head
