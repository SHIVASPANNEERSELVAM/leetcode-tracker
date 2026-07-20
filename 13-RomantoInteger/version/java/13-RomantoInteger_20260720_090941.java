// Last updated: 7/20/2026, 9:09:41 AM
1class Solution {
2    public boolean isPalindrome(ListNode head) {
3        ListNode slow = head, fast = head, prev, temp;
4        while (fast != null && fast.next != null) {
5            slow = slow.next;
6            fast = fast.next.next;
7        }
8        prev = slow;
9        slow = slow.next;
10        prev.next = null;
11        while (slow != null) {
12            temp = slow.next;
13            slow.next = prev;
14            prev = slow;
15            slow = temp;
16        }
17        fast = head;
18        slow = prev;
19        while (slow != null) {
20            if (fast.val != slow.val) return false;
21            fast = fast.next;
22            slow = slow.next;
23        }
24        return true;
25    }
26}