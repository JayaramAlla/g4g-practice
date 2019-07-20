package Trees;
// INITIAL CODE

import java.util.HashMap;
import java.util.Scanner;
// A Binary Search Tree node

public class Check_BST
{
     private static class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    /*void printInorder(Trees.Node node)
    {
        if (node == null)
            return;
        /* first recur on left child */
    //printInorder(node.left);
    /* then print the data of node */
    // System.out.print(node.data + " ");
    /* now recur on right child */
    //printInorder(node.right);
    //}*/
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Check_BST ob = new Check_BST();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();

            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
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
                n--;
            }

            GfG g = new GfG();
            System.out.println(g.isBST(root));
            //ob.printInorder(root);
            t--;

        }
    }

    /*This is a function problem.You only need to complete the function given below*/
    /*  A Binary Search Tree node
    class Trees.Node
    {
        int data;
        Trees.Node left, right;
        Trees.Node(int item)
        {
            data = item;
            left = right = null;
        }
    } */

    private static class GfG
    {
        int isBST(Node root)
        {
            // Your code here
            return bstUtil(root).isBst ? 1:0;

        }

        Resp bstUtil(Node root){
            Resp resp = new Resp(null,null, true);
            if(root == null){
                return resp;
            }

            if(root.left != null){
                Resp left = bstUtil(root.left);
                if( !left.isBst || root.data < left.max){
                    resp.isBst = false;
                    return  resp;
                }
                resp.min = left.min;
            }else {
                resp.min = root.data;
            }
            if(root.right != null){
                Resp right = bstUtil(root.right);
                if(!right.isBst || root.data < right.min){
                    resp.isBst = false;
                    return resp;
                }
                resp.max = right.max;
            }else{
                resp.max = root.data;
            }
            return resp;
        }

    private static class Resp{
            Integer min;
            Integer max;
            Boolean isBst;
            public Resp(Integer min, Integer max, Boolean isBst){
                this.min= min;
                this.max = max;
                this.isBst = isBst;
            }
        }
    }
}


