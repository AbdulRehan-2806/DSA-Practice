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
    public int pairSum(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) 
        {
            len++;
            temp = temp.next;
        }
        int mid = len / 2;
        temp = head;
        while(mid-- > 0)
            temp = temp.next;
        ListNode second = reverse(temp);
        ListNode first = head;
        int ans = 0;
        while(second != null)
        {
            ans = Math.max(ans, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return ans;    
    }
    static ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null)
        {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}