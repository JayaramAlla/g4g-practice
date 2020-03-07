package Algorithims;

import java.util.ArrayList;
import java.util.List;

public class Paranthasis {
    /*
     * created by Jayaram on 12/02/20
     */


    public static final String paranth = "{}";

    public static void main(String[] args){
        List<String> resp = getPranths(0);
        for(String s : resp){
            System.out.println(s);
        }
    }



    public static List<String> getPranths(int n){
        List<String> set = new ArrayList<>();
        if(n <= 0){
            return set;
        }
        if(n == 1){
            set.add("{}");
            return set;
        }

        List<String> resp =  getPranths(n-1);

        for(String s : resp){
            set.add(s+paranth);
            set.add("{"+s+"}");
            set.add(paranth+s);
        }


        return set;
    }
}
