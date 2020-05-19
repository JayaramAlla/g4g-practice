package DynamicProgramming.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindrome {
    /*
     * created by Jayaram on 09/03/20
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        while (s != null){
            if(s.equals("STOP")){
                return;
            }
            Solution solution = new Solution();
            char[] arry = s.toCharArray();
            System.out.println(solution.longestPalindromeDp(arry,0,arry.length-1));
            s =reader.readLine();
        }
    }

    private static class Solution {
        String[][] dp = new String[1000][1000];

        public String longestPalindrome(String s) {

            System.out.println("call for string for "+ s);
            if(s == null || s.length() < 2){
                return s;
            }
            int len = s.length();
            char[] arry = s.toCharArray();
            String s1 = "";
            if(arry[0] == arry[len-1]){
                s1 = longestPalindrome(s.substring(1,len-1));
                if(s1.length() == len-2){
                    System.out.println("response for "+ s+" with result "+s1);
                    return s;
                }
            }
            String s2 = longestPalindrome(s.substring(0,len-1));
            String s3 = longestPalindrome(s.substring(1,len));
            String result = returnLongest(returnLongest(s1,s2),s3);
            System.out.println("response for "+ s+" with result "+result);
            return result;
        }

        public String longestPalindromeDp(char[] arry,int i ,int j){
            if( arry.length < 2){
                return new String(arry);
            }
//            if(i > j || i == arry.length){
            if(i > j ){
                return "";
            }
            if(i == j){
                dp[i][j] = arry[i]+"";
                return dp[i][j];
            }
            if(dp[i][j] != null){
                return dp[i][j];
            }
            String s1 = "";
            if(arry[i] == arry[j]){
                s1 = longestPalindromeDp(arry,i+1,j-1);
                if(s1 != null && s1.length() == j+1-i-2){
                    dp[i][j] = new String(arry,i,j+1-i);
                    return dp[i][j];
                }
            }
            String s2 = longestPalindromeDp(arry,i,j-1);
            String s3 = longestPalindromeDp(arry,i+1,j);
            String result = returnLongest(returnLongest(s1,s2),s3);
            dp[i][j]= result;
            return result;
        }


        public String returnLongest(String s1,String s2){
            if(s2 == null || s2.length() == 0){
                return s1;
            }
            if(s1 == null || s1.length() ==0){
                return s2;
            }

            return  s1.length() > s2.length() ? s1:s2;
        }
    }
}
