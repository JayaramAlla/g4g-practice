package Arrays;

public class FindDuplicateNumber {
    /*
     * created by Jayaram on 05/12/20
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

Follow-ups:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem without modifying the array nums?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)?
     */

    // using the same approach as finding first node in cyclic linkedlist BOOOM
    private class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0], fast = nums[nums[0]];
            while( slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while(fast != slow){
                fast = nums[fast];
                slow = nums[slow];
            }

            return fast;

        }
    }

}
