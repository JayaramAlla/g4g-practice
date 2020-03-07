package LinkedLists;

public class MergeSortedLists {
    /*
     * created by Jayaram on 07/03/20
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    private class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }
            if(l1.val > l2.val){
                l2.next = mergeTwoLists(l1,l2.next);
                return l2;
            }
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }

        //y does this take less space then the above one????
        public ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode r) {
            if(l1 == null) return l2;
            else if(l2 == null) return l1;
            else {
                if(l1.val < l2.val) {
                    r = l1;
                    r.next = mergeTwoLists(l1.next, l2, r.next);
                    return r;
                } else {
                    r = l2;
                    r.next = mergeTwoLists(l1, l2.next, r.next);
                    return r;
                }
            }
        }

    }


    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
