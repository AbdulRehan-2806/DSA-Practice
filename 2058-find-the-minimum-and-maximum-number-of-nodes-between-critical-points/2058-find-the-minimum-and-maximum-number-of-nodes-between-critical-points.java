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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[2];
        List<Integer> al = new ArrayList<>();
        Arrays.fill(res,-1);
        if(head == null || (head.next == null || head.next.next == null)) return res;
        ListNode prev = head , cur = head.next , nxt = cur.next;
        int idx = 1;
        ListNode ptr = cur;
        int min = -1;
        int max = -1;
        int pre = -1;
        int mini = Integer.MAX_VALUE;
        while(nxt != null)
        {
            if(prev.val > cur.val && cur.val < nxt.val){
                    if(min == -1) min = idx;
                    max = idx;
                    if(pre != -1) mini = Math.min(mini ,idx - pre);
                    pre = idx;

            }
            if(prev.val < cur.val && cur.val > nxt.val){
                if(min == -1) min = idx;
                max = idx;
                if(pre != -1) mini = Math.min(mini , idx-pre);
                pre = idx;
            }
            prev = cur;
            cur = nxt;
            nxt = nxt.next;
            idx++;
        }
        if(min == -1 || (max == -1 || mini == Integer.MAX_VALUE)) return res;
        res[0] = mini;
        res[1] = max - min;
        
        return res;
    }
}