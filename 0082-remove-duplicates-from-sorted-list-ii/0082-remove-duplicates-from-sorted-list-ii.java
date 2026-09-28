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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy , cur = head;
        if(head == null || head.next == null) return head;
        while(cur != null)
        {
            ListNode next = cur.next;
            while(next != null && cur.val == next.val) next = next.next;
            if(cur.next != next)
            {
                cur = next;
            }
            else{
                prev.next = cur;
                prev = cur;
                cur = next;
            }
        }
        prev.next = null;
        return dummy.next;
    }
}