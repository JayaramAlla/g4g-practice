package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDfs {
    /*
     * created by Jayaram on 13/11/20
     */
    class Solution {

        public int minReorder(int n, int[][] con) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0;i < con.length; i++){
                map.putIfAbsent(con[i][0], new ArrayList<>());
                map.get(con[i][0]).add(con[i][1]);
                map.putIfAbsent(con[i][1], new ArrayList<>());
                map.get(con[i][1]).add(-1*con[i][0]);
            }

            return dfs(0,map, 0);

        }


        int dfs(int prev,Map<Integer, List<Integer>> map,int index){
            int count = 0;
            for(Integer node: map.get(index)){
                if(Math.abs(node) == prev){
                    continue;
                }
                if(node > 0){
                    count++;
                }
                count += dfs(index, map, Math.abs(node));
            }
            return count;
        }

    }
}
