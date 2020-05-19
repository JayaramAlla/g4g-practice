package Arrays;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixNumbers {
    /*
     * created by Jayaram on 12/11/19
     */

    private class Solution {
        public int[][] generateMatrix(int n) {
            int[][] mat = new int[n][n];
            int val = 1;
            for(int i =0;i<n;i++){
                int j=i,k=i;
                while(k+i<n){
                    mat[j][k] = val++;
                    // printMatrix(mat);
                    k++;
                }
                j++;
                k--;
                while(j+i<n){
                    mat[j][k] = val++;
                    // printMatrix(mat);
                    j++;
                }
                j--;
                k--;
                while(k-i >=0){
                    mat[j][k] = val++;
                    // printMatrix(mat);
                    k--;
                }
                k++;
                j--;
                while(j-i > 0){
                    mat[j][k] = val++;
                    // printMatrix(mat);
                    j--;
                }
                j++;
            }
            return mat;
        }

        private void printMatrix(int[][] mat){
            for(int i =0;i< mat.length;i++){
                for(int j =0;j<mat.length;j++){
                    System.out.print(mat[i][j]+", ");
                }
                System.out.println();
            }
            System.out.println("---------------------------");
        }
    }
    class Solution2 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new LinkedList<>();
            if (matrix == null || matrix.length == 0) return res;
            int n = matrix.length, m = matrix[0].length;
            int up = 0,  down = n - 1;
            int left = 0, right = m - 1;
            while (res.size() < n * m) {
                for (int j = left; j <= right && res.size() < n * m; j++)
                    res.add(matrix[up][j]);

                for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                    res.add(matrix[i][right]);

                for (int j = right; j >= left && res.size() < n * m; j--)
                    res.add(matrix[down][j]);

                for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                    res.add(matrix[i][left]);

                left++; right--; up++; down--;
            }
            return res;
        }
    }
}
