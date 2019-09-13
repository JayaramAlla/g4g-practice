package Trees;

import java.util.Scanner;

public class BST_Lowest_Common_Ancestor {
    /*
     * created by Jayaram on 15/08/19
     */
    Node root;

    void insert(Node root, int key)
    {
        if(key < root.data)
        {
            if(root.left != null)
                insert(root.left, key);
            else
            {
                root.left = new Node(key);
            }
        }
        else if(key > root.data)
        {
            if(root.right != null)
                insert(root.right, key);
            else
            {
                root.right = new Node(key);
            }
        }
    }

    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0)
        {
            int n = sc.nextInt();
            BST_Lowest_Common_Ancestor tree = new BST_Lowest_Common_Ancestor();
            int a1 = sc.nextInt();
            Node root = new Node(a1);

            for(int i=1;i<n;i++)
            {
                int a = sc.nextInt();
                tree.insert(root,a);
            }

            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            BST g = new BST();
            Node s = g.LCA(root, n1, n2);
            System.out.println(s.data);

            t--;
        }
    }
}



/*This is a function problem.You only need to complete the function given below*/
/* A Binary Search Tree node */
/* class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class BST
{
    //For non binary tree least common ancestor
    Node LCA(Node node, int n1, int n2)
    {
        // Your code here
        boolean oneValueFound = false;
        if(node.data == n1 || node.data == n2){
            oneValueFound = true;
        }

        Node node1 = null;
        if(node.right != null){
            node1 = LCA(node.right,n1,n2);
        }
        Node node2 = null;
        if(node.left != null){
            node2 =  LCA(node.left,n1,n2);
        }

        if(node1 != null  && node2 != null){
            return node;
        }
        if(node1 != null || node2 != null){
            if(oneValueFound){
                return node;
            }
            return node1 == null? node2:node1;
        }


        return oneValueFound? node: null;
    }
    Node lca(Node node, int n1, int n2)
    {
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2)
            return lca(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2)
            return lca(node.right, n1, n2);

        return node;
    }

//    Node lcaIterative(Node n ,int n1,int n2){
//
//    }

}