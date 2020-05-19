package StringsAlgos;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    /*
     * created by Jayaram on 12/03/20
     */
    private static class Solution {//sliding window

        public int lengthOfLongestSubstringMine(String s) {
            if(s == null || s.length() ==0){
                return 0;
            }
            char[] arry = s.toCharArray();
            Map<String,Integer> map = new HashMap<>();
            int i = 0,max =1;
            map.put(arry[i]+"",i);
            for(int y =1;y < s.length() ;y++){
                String p = arry[y]+"";
                if( map.containsKey(p)){
                    int x = map.get(p);
                    for(int j=i ;j<=x;j++){
                        map.remove(arry[j]+"");
                    }
                    i = x+1;
                }
                map.put(p,y);
                if(y-i+1 > max){
                    max = y-i+1;
                }
            }
            return max;
        }
        //most optimal
        public int lengthOfLongestSubstring(String s) {
            if (s == null) return 0;
            int[] hash = new int[128];
            int left = 0, right = 0, cnt = 0, maxLen = 0;
            while (right < s.length()) {
                if (hash[s.charAt(right)] > 0) cnt++;
                hash[s.charAt(right)]++;
                right++;
                while (cnt > 0) {
                    if (hash[s.charAt(left)] >= 2) cnt--;
                    hash[s.charAt(left)]--;
                    left++;
                }
                if (cnt == 0 && left <= right) maxLen = Math.max(maxLen, right - left);
            }
            return maxLen;
        }
    }
}
