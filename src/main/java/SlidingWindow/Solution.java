package SlidingWindow;

import java.util.ArrayList;
import java.util.List;
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p == null || s == null || s.length() < p.length()){
            return list;
        }
        int[] arry = new int[26];
        int[] resp = new int[26];
        for(char c:p.toCharArray()){
            arry[c-'a']++;
        }
        int r = 0,l = p.length()-2,count = 0;
        for(int i =0;i<p.length()-1;i++){
            if(++resp[s.charAt(i)-'a'] <= arry[s.charAt(i)-'a']){
                count++;
            }
        }
        
        while(++l < s.length()){//cba c=3
            if(++resp[s.charAt(l)-'a'] <= arry[s.charAt(l)-'a']){
                count++;
            }
            if(count == p.length()){
                list.add(r);
            }
            if(resp[s.charAt(r)-'a']-- <= arry[s.charAt(r)-'a']){
                count--;
            }
            r++;
        }
        return list;
        
    }
}