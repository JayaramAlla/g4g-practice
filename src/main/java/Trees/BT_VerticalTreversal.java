package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BT_VerticalTreversal {
    /*
     * created by Jayaram on 02/08/19
     */

//Initial Template for Java



    public static void main (String[] args)throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = Integer.parseInt(read.readLine());
            Node root = null;
            String str[] = read.readLine().replace("  ", " ").trim().split(" ");
            int k = 0;
            while(n-- > 0)
            {
                int n1 = Integer.parseInt(str[k++]);
                int n2 = Integer.parseInt(str[k++]);
                char lr= str[k++].charAt(0);


                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
            }

            BinaryTree obj = new BinaryTree();
            obj.verticalOrder(root);
            System.out.println();
        }
    }


    /*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left, right;

    Node(int key)
    {
        data = key;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}*/
    static class BinaryTree
    {
        static void verticalOrder(Node root)
        {
            // add your code here
            Map<Integer,List<Integer>> map = new HashMap<>();
            Queue<Node> que = new LinkedList<Node>();
            que.add(root);
            root.hd = 0;
            while(!que.isEmpty()){
                int n= que.size();
                while(n-- > 0){
                    Node node = que.poll();
                    if(map.containsKey(node.hd)){
                        map.get(node.hd).add(node.data);
                    }else{
                        List<Integer> arry = new ArrayList<>();
                        arry.add(node.data);
                        map.put(node.hd,arry);
                    }
                    if(node.left != null){
                        node.left.hd = node.hd-1;
                        que.add(node.left);
                    }
                    if(node.right != null){
                        node.right.hd = node.hd+1;
                        que.add(node.right);
                    }
                }
            }
            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            for(Integer key:keys){
                List<Integer> arry = map.get(key);
                for(Integer val : arry){
                    System.out.print(val+" ");
                }
            }

        }
    }
}
