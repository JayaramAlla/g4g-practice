package Arrays;

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
}
