package DynamicProgramming;

public class DungeonGame {
    /*
     * created by Jayaram on 24/11/20
     */
    private class Solution {
        public int calculateMinimumHP(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m+1][n+1];
            int max = Integer.MAX_VALUE;
            dp[m-1][n-1] = Math.max(1 - grid[m-1][n-1], 1);
            for(int i = m-1;i >= 0 ; i--){
                for(int j = n-1; j >= 0;j--){
                    if(i != m-1 || j != n-1){
                        dp[i][j] = Math.max(1, Math.min( i < m-1 ? dp[i+1][j]: max, j < n-1 ? dp[i][j+1]: max) - grid[i][j]);
                    }
                }
            }
            return dp[0][0];
        }
    }
}
