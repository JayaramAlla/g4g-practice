package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArrayWithSum {
    /*
     * created by Jayaram on 16/04/20
     */

    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String sr = r.readLine();
        String[] s1 = sr.split(" ");
        int t = Integer.parseInt(s1[0]);
        for(int i =0;i< t;i++){
            String sr1 = r.readLine();
            String[] s2 = sr1.split(" ");
            int n = Integer.parseInt(s2[0]);
            Long a = Long.parseLong(s2[1]);
            String sr2 = r.readLine();
            String[] s3 = sr2.split(" ");
            int[] arry = new int[n];
            for(int j=0;j<n;j++){
                arry[j] = Integer.parseInt(s3[j]);
            }
            int p=0,q=0;
            Long sum= arry[0]*1l;
            while(q<n && p<n){
                if(a.equals(sum)){
                    System.out.println((p+1)+" "+(q+1));
                    break;
                }
                if(a < sum){
                    sum = sum - arry[p];
                    p++;
                }else{
                    q++;
                    if(q== n){
                        break;
                    }
                    sum +=arry[q];
                }
            }
            if(p == n || q == n){
                System.out.println(-1);
            }

        }
    }
}
