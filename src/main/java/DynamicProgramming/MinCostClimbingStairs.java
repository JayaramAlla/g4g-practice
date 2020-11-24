package DynamicProgramming;

public class MinCostClimbingStairs {
    /*
     * created by Jayaram on 24/11/20
     */
    private class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length+1];
            for(int i =2;i<= cost.length;i++){
                dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i -2]+cost[i-2]);
            }
            return dp[cost.length];
        }

        //number of ways to climb 1 or 2 steps
        public int climbStairs(int n) {
            int[] dp = new int[n+2];
            dp[1] = 1;
            dp[0] = 1;
            for(int i =2;i<= n ;i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
}
