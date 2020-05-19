package Sorting;

public class LinkedListMergeSort {
    /*
     * created by Jayaram on 09/03/20
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
        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        public ListNode mergeSort(ListNode head){
            if(head == null){
                // System.out.println("null value");
                return null;
            }
            // System.out.println(head.val);
            ListNode slow = head , fast = head,temp = slow;
            int count = 0;
            while( fast != null && fast.next != null){
                count++;
                temp = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if(count < 1){
                return head;
            }
            temp.next = null;

            head = mergeSort(head);
            slow  = mergeSort(slow);
            // printer(head);
            // printer(slow);
            return mergeList(head,slow);
        }

        public ListNode mergeList(ListNode head,ListNode head1){
            if(head == null){
                return head1;
            }
            if(head1 == null){
                return head;
            }
            ListNode temp,first ;
            if(head.val < head1.val){
                temp = head;
                head = head.next;
            }else {
                temp = head1;
                head1 = head1.next;
            }
            first = temp;
            while(head != null && head1 != null){
                if(head.val < head1.val){
                    temp.next = head;
                    head = head.next;
                    temp = temp.next;
                }else {
                    temp.next = head1;
                    temp = head1;
                    head1 = head1.next;
                }
            }
            if(head1 != null){
                temp.next = head1;
            }
            if(head != null){
                temp.next = head;
            }
            return first;
        }

        public void printer(ListNode head){
            while(head != null){
                System.out.print(head.val+",");
                head = head.next;

            }
            System.out.println("");
        }
    }

    private class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
