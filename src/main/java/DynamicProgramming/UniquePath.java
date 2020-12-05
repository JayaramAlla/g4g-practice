package DynamicProgramming;

public class UniquePath {
    /*
     * created by Jayaram on 25/11/20
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
     */
    private class Solution {
        public int uniquePaths(int m, int n) {
            int[][] arry = new int[m][n];
            return uniquePath(m-1,n-1,arry);

        }

        public int uniquePath(int m,int n , int[][] arry){
            if(m < 0 || n < 0){
                return 0;
            }
            if(arry[m][n] != 0){
                return arry[m][n];
            }
            if(m == 0 || n== 0){
                arry[m][n] = 1;
                return 1;
            }
            arry[m][n] = uniquePath(m-1,n,arry) + uniquePath(m,n-1,arry);
            return arry[m][n];
        }
    }
}
