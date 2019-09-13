package Recursive;

public class IslandPerimeter {
    /*
     * created by Jayaram on 13/09/19
     */
    private class Solution {
        int[] axisx = new int[]{1,-1,0,0};
        int[] axisy = new int[]{0,0,1,-1};
        public int islandPerimeter(int[][] grid) {
            int count =0;
            for(int x=0;x<grid.length;x++){
                for(int y=0;y < grid[0].length;y++){
                    if(grid[x][y] == 1){
                        //island(grid,x,y);
                        count += 4 - (x>0 ? 2*grid[x-1][y]:0 ) - (y>0 ? 2*grid[x][y-1]:0 );
                    }
                }
            }
            return count;
        }

        public int island(int[][] grid,int x,int y){
            if( grid[x][y] != 1){
                return 0;
            }

            grid[x][y] = 2;
            int count =0;
            for(int i=0;i<axisx.length;i++){
                int a = x + axisx[i];
                int b = y + axisy[i];
                if(isOutOfBoundary(grid,a,b) || grid[a][b] == 0){
                    count++;
                }else{
                    count +=island(grid,a,b);
                }
            }

            return count;


        }

        public boolean isOutOfBoundary(int[][] grid,int x, int y){
            if(x >= grid.length || y >= grid[0].length || x < 0 || y < 0){
                return true;
            }
            return false;
        }
    }
}
