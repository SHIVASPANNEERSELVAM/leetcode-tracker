// Last updated: 7/20/2026, 4:10:05 PM
1class Solution {
2    public ListNode reverseBetween(ListNode head, int left, int right) {
3        if (head == null || left == right) {
4            return head;
5        }
6
7        ListNode dummy = new ListNode(0);
8        dummy.next = head;
9        ListNode prev = dummy;
10
11        for (int i = 0; i < left - 1; i++) {
12            prev = prev.next;
13        }
14
15        ListNode cur = prev.next;
16
17        for (int i = 0; i < right - left; i++) {
18            ListNode temp = cur.next;
19            cur.next = temp.next;
20            temp.next = prev.next;
21            prev.next = temp;
22        }
23
24        return dummy.next;        
25    }
26}