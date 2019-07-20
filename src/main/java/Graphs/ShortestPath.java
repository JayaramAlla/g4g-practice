package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestPath {
    /*
     * created by Jayaram on 15/06/19
     */

    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for(int i = 0;i < t;i++){
            int n = Integer.parseInt(reader.readLine());
            usingDpSimpleOne(n);
        }
    }

    public static void usingDpSimpleOne(int n ){
        int[] d = new int[10001];
        if(n == 1 || d[n] != 0){
            System.out.println(d[n]);
        }else {
            for(int j = 2 ; j<= n;j++){

                d[j]  = j%3 == 0 ?Math.min(d[j-1]+1, d[j/3] +1): d[j-1]+1;
                //System.out.print("j "+j+"v "+d[j]+", ");
            }
            System.out.println(d[n]);
        }
    }

}
