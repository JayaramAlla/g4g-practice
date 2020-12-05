package DynamicProgramming;

public class HouseRobber {
    /*
     * created by Jayaram on 25/11/20
     */
    private class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            for(int i =0;i< nums.length;i++)
                dp[i] = -1;
            return robDp(nums,dp,0);
        }
        //recursive bottom up O(N) space due to recursive and extra arry
        //can be done by using loop and top bottom with current = max of (previous, before previous +  current)
        private int robDp(int[] nums, int[] dp,int start){
            if(start >= nums.length){
                return 0;
            }
            if(dp[start] == -1){
                dp[start] = Math.max(robDp(nums,dp,start+2)+nums[start],robDp(nums,dp,start+1));
            }
            return dp[start];

        }

        /*
        * Circular house:
        *  Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
        * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected,
         * and it will automatically contact the police if two adjacent houses were broken into on the same night.
        * */
        public int robCircularHouses(int[] nums) {
            int[] dp = new int[nums.length+1];
            int max = 0;
            if(nums.length < 4){// Handle special case where length is less than 4
                for(int i = 0;i< nums.length;i++){
                    if(nums[i] > max){
                        max = nums[i];
                    }
                }
                return max;
            }
            dp[0] = nums[0];
            dp[1] = nums[0];
            for(int i =2;i< nums.length-1;i++){// run dp once considering the first house
                dp[i] = Math.max(dp[i-1],dp[i-2]+ nums[i]);
            }
            max = dp[nums.length-2];

            dp[0] = 0;
            dp[1] = nums[1];
            for(int i =2;i< nums.length;i++){// run dp once without considering the first house
                dp[i] = Math.max(dp[i-1],dp[i-2]+ nums[i]);
            }
            if(max < dp[nums.length-1]){
                max = dp[nums.length-1];
            }
            return max;
        }
    }
}
