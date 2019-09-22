package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;

public class MaximumSumProblem {// same as coin problem
    /*
     * created by Jayaram on 22/09/19
     * Given a number n, we can divide it in only three parts n/2, n/3 and n/4 (we will consider only integer part). The task is to find the maximum sum we can make by dividing number in three parts recursively and summing up them together.
Note: Sometimes, the maximum sum can be obtained by not dividing n.
     */
    public static void main (String[] args) throws Exception
    {
        //code
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long T = Long.parseLong(reader.readLine().trim());
        int[] dp = new int[100000];
        while(T-- > 0){
            int a = Integer.parseInt(reader.readLine().trim());
            //for(int i=1;i<=a;i++){
            //    dp[i] = Math.max(i,dp[i/2]+dp[i/3]+dp[i/4]);
            //}
            System.out.println(sum(a,dp));
        }
    }

    public static int sum(int n,int[] dp){
        if(dp[n] != 0 || n == 0){
            return dp[n];
        }
        dp[n] = Math.max(n,sum(n/2,dp)+sum(n/3,dp)+sum(n/4,dp));
        return dp[n];
    }
}
