// Last updated: 7/20/2026, 4:08:36 PM
1class Solution {
2    public ListNode partition(ListNode head, int x) {
3        ListNode slist = new ListNode();
4        ListNode blist = new ListNode();
5        ListNode small = slist;
6        ListNode big = blist;
7
8        while (head != null) {
9            if (head.val < x) {
10                small.next = head;
11                small = small.next;
12            } else {
13                big.next = head;
14                big = big.next;
15            }
16
17            head = head.next;
18        }
19
20        small.next = blist.next;
21        big.next = null;
22
23        return slist.next;        
24    }
25}