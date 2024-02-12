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
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow;
        ListNode prev = null;
        ListNode Next = current.next;

        while(current  != null){
            current.next = prev;
            prev = current;
            current = Next;
            if(Next != null) Next = Next.next;
        }


        
        int max = 0;
        ListNode h1 = head;
        ListNode h2 = prev;
        while(h1 != null && h2 != null){
            max = Math.max(max,h1.val + h2.val);
            h1 = h1.next;
            h2 = h2.next;
        }
        return max;
    }
    
}
