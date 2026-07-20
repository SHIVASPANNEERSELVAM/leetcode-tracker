# Last updated: 7/20/2026, 10:08:10 AM
1class Solution(object):
2    def insertionSortList(self, head):
3        if not head or not head.next:
4            return head
5        dummy = ListNode(-float('inf'))
6        dummy.next = head
7        cur = head
8        while cur and cur.next:
9            if cur.next.val >= cur.val:
10                cur = cur.next
11            else:
12                tmp = cur.next
13                cur.next = tmp.next
14                pre = dummy
15                while pre.next.val < tmp.val:
16                    pre = pre.next
17                tmp.next = pre.next
18                pre.next = tmp
19        return dummy.next