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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for(int i = 0; i < k ; i++){
            if(temp == null){
                return head;
            }
            temp = temp.next;
        }
        ListNode newhead = reverse(head , temp);
        head.next = reverseKGroup(temp , k);
        return newhead;

        
    }
    public ListNode reverse(ListNode cur , ListNode end){
        ListNode prev = null;
        while(cur != end){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
}