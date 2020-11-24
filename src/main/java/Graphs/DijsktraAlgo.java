package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijsktraAlgo {
    /*
     * created by Jayaram on 12/11/20
     */
    private class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            boolean[] isVisited = new boolean[N+1];
            Map<Integer, Map<Integer,Integer>> weightMap = new HashMap<>();
            for(int[] time: times){
                weightMap.putIfAbsent(time[0],new HashMap<>());
                weightMap.get(time[0]).put(time[1],time[2]);
            }
            int[] dist = new int[N+1];
            for(int i = 0;i<= N;i++){
                dist[i] = Integer.MAX_VALUE;
            }
            dist[K] = 0;
            for(int i = 1;i<=N;i++){
                int u = getMinNextNode(dist,isVisited);
                if(u == -1){
                    return -1;
                }
                isVisited[u] = true;
                Map<Integer, Integer> nodes = weightMap.get(u);
                if(nodes != null){
                    for(Integer node: nodes.keySet()){
                        if(nodes.get(node) + dist[u] < dist[node]){
                            dist[node] = nodes.get(node) + dist[u];
                        }
                    }
                }

            }
            int max = 0;
            for(int i =1 ;i<= N ; i++){
                if(!isVisited[i])
                    return -1;
                if(dist[i] > max)
                    max = dist[i];
            }
            return max;

        }

        public int networkDelayTime1(int[][] times, int N, int K) {// Suggested solution
            Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
            for(int[] time : times){
                map.putIfAbsent(time[0], new HashMap<>());
                map.get(time[0]).put(time[1], time[2]);
            }

            //distance, node into pq
            Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

            pq.add(new int[]{0, K});

            boolean[] visited = new boolean[N+1];
            int res = 0;

            while(!pq.isEmpty()){
                int[] cur = pq.remove();
                int curNode = cur[1];
                int curDist = cur[0];
                if(visited[curNode]) continue;
                visited[curNode] = true;
                res = curDist;
                N--;
                if(map.containsKey(curNode)){
                    for(int next : map.get(curNode).keySet()){
                        pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                    }
                }
            }
            return N == 0 ? res : -1;

        }


        public int getMinNextNode(int[] dist,boolean[] isVisited){
            int min = Integer.MAX_VALUE;
            int val = -1;
            for(int i =1;i< dist.length;i++){
                if(!isVisited[i]  && dist[i] < min){
                    val = i;
                    min = dist[i];
                }
            }
            return val;
        }
    }
}
