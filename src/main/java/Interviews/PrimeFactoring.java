package Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactoring {
    /*
     * created by Jayaram on 19/01/20
     */

    public static void main(String[] args){
        //skipping the standard input processing
        int[] arry = {2,3,4,5,10};
        int n  = 10;
        // solution

        //sort the array
         Arrays.sort(arry);
        List<Integer> result = divisible(n, arry, arry.length - 1);
        if(result == null || result.size() == 0){
            System.out.println(-1);
        }
        for(int i  = 0;i < result.size() ;i++){
            System.out.print(result.get(i) + " ");
        }
    }

    //purpose of the last is to ensure we are not checking already checked elements
    public static List<Integer> divisible(int n,int[] arrys, int last){
        List<Integer> list = new ArrayList<>();
        if(n == 1){
            list.add(1);
            return list;
        }
        for(int i = last ; i >= 0 ; i--){
            if(arrys[i] == 0){
                return null;
            }
            if(n%arrys[i] == 0){
                List<Integer> resp = divisible(n/arrys[i], arrys, i);
                if(resp != null || resp.size() > 0){
                    resp.add(n);
                    return resp;
                }
            }
        }

        return null;
    }


}
