package DynamicProgramming;

public class MinSumPathInArray {
    /*
     * created by Jayaram on 24/11/20
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
        Note: You can only move either down or right at any point in time.
     */
    private class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m+1][n+1];
            int max = Integer.MAX_VALUE;
            dp[0][0] = grid[0][0];
            for(int i =0;i<m ; i++){
                for(int j = 0; j< n;j++){
                    if(i != 0 || j != 0){
                        dp[i][j] = Math.min(i > 0 ? dp[i-1][j]: max, j > 0 ? dp[i][j-1]: max) + grid[i][j];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }
}
