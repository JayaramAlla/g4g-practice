package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestWithMaxKElements {
    /*
     * created by Jayaram on 15/11/19
     */

    //this only works with only size 2 with time O(N) and space O(1)
    private static class Solution {
        public int totalFruit(int[] tree) {
            // int[] currentValues = {tree[0],-1};
            Set<Integer> set = new HashSet<>();
            set.add(tree[0]);
            int p1 = -1;
            int w1 = 0;
            int len = 0;
            for(int i =1 ; i<tree.length;i++){
                if(set.contains(tree[i])){
                    if(tree[i-1] != tree[i]){
                        p1 = i-1;
                    }
                    if(i - w1 > len){
                        len = i- w1;
                    }
                }else if(set.size() < 2){
                    p1 = i-1;
                    set.add(tree[i]);
                    if(i - w1 > len){
                        len = i- w1;
                    }
                }else {

                    w1 = p1 + 1;
                    set.remove(tree[p1]);
                    set.add(tree[i]);
                    p1 = i-1;
                }
            }
            return len+1;
        }
    }

    //given solution
    //sliding window used better with 2 sides moving with one adding and other removing this supports K of any size
    // but takes an extra space of O(K)
    private class Solution1 {
        public int totalFruit(int[] tree) {
            int ans = 0, i = 0;
            Counter count = new Counter();
            for (int j = 0; j < tree.length; ++j) {
                count.add(tree[j], 1);
                while (count.size() >= 3) {
                    count.add(tree[i], -1);
                    if (count.get(tree[i]) == 0)
                        count.remove(tree[i]);
                    i++;
                }

                ans = Math.max(ans, j - i + 1);
            }

            return ans;
        }
    }

    class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }
}
