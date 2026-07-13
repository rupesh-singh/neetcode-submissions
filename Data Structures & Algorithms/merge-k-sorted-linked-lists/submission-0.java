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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode n: lists){
            while(n != null){
                pq.add(n.val);
                n = n.next;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(!pq.isEmpty()){
            ListNode node = new ListNode(pq.poll());
            temp.next = node;
            temp = temp.next; 
        }

        return head.next;
    }
}
