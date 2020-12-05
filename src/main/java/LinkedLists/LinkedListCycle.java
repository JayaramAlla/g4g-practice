package LinkedLists;

public class LinkedListCycle {
    /*
     * created by Jayaram on 05/12/20
     */
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     a +kN +b =  2a + 2b
     Kn = a + c + pN;

     */
    private class Solution {


        public ListNode detectCycleHead(ListNode head) {
            ListNode slow = head, fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    while(head != slow){
                        head = head.next;
                        slow = slow.next;
                    }
                    return head;
                }
            }
            return null;
        }
    }

    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
}
