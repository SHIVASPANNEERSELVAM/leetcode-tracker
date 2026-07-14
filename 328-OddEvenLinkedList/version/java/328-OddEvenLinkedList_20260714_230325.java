// Last updated: 7/14/2026, 11:03:25 PM
1class Solution {
2    public ListNode oddEvenList(ListNode head) {
3        if(head == null || head.next == null) return head;
4        ListNode odd = head, even = head.next, evenHead = even;
5        while(even!=null && even.next != null){
6            odd.next = even.next;
7            odd = odd.next;
8            even.next = even.next.next;
9            even = even.next;
10        }
11        odd.next = evenHead;
12        return head;
13    }
14}