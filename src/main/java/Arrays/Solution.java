package Arrays;

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
    public ListNode rotateRight(ListNode head, int k) {
        int len = getLength(head);
        if(len == 0 || k%len == 0) return head;
        k = k%len;
        k = len -k;
        ListNode node = head;
        while(--k > 0){
            node = node.next;
            
        }
        ListNode ite = node.next;
        node.next = null;
        node = ite;
        while(ite.next != null){
            ite = ite.next;
        }
        ite.next = head;
        return node;
    }
    
    public int getLength(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}