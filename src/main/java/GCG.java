import java.util.Arrays;
import java.util.Scanner;

public class GCG {
    /*
     * created by Jayaram on 01/06/19
     */

        public static void main (String[] args) {
            //code
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            for(int i =0; i < t ;i++){
                int n = scan.nextInt();
                int[] arry = new int[n];
                for(int j=0;j<n-1;j++){
                    arry[j] = scan.nextInt();
                }
                Arrays.sort(arry);
                System.out.println(arry);
                System.out.println(getMissingNumber(0,n-1,arry));
            }
        }

        public static int getMissingNumber(int start,int end,int[] arry){
            System.out.println(start+" e "+end);
            if(start > end){
                return -1;
            }
            int mid = (start+end)/2;

            if(arry[mid]-mid ==1 && (mid-1 < 0 || arry[mid-1]-(mid-1) == 0)){
                return mid;
            }
            if(arry[end] - end == 0){
                return end+1;
            }

            if( arry[mid] - mid == 0){
                return getMissingNumber(mid+1,end,arry);
            }
            return getMissingNumber(start,mid-1,arry);
        }
}
