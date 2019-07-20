package Graphs;

import java.util.*;
import java.lang.*;
import java.io.*;
class DependenciesSum
{
    public static void main (String[] args) throws IOException {
        //code
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for(int i = 0 ;i < t;i++){
            String[] line1 = reader.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int e = Integer.parseInt(line1[1]);
            Map<Integer, GraphNode> map = new HashMap<>();
            for(int j = 0;j< n;j++){
                map.put(j,new GraphNode(j,e));
            }
            String[] line2 = reader.readLine().split(" ");
            for(int j = 0;j<e;j++){
                int a = Integer.parseInt(line2[j]);
                int b = Integer.parseInt(line2[++j]);
                GraphNode node1 = map.get(a);
                GraphNode node2 = map.get(b);
                int x = 0;
                while(node1.arry[x] != null) x++;
                node1.arry[x] = node2;
            }
            System.out.println(e);
        }
        reader.close();


    }
}

