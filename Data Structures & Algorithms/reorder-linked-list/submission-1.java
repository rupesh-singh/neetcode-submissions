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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) 
            return;

        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = slow.next;
        slow.next = null; // break list
        ListNode reverse = reverseList(second);

        // Step 3: Merge two halves
        ListNode first = head;
        while (reverse != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = reverse.next;

            first.next = reverse;
            reverse.next = tmp1;

            first = tmp1;
            reverse = tmp2;
        }
    
    
    }

        public ListNode reverseList(ListNode head) {
        ListNode temp=head, prev=null, next=null;

        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }


}
