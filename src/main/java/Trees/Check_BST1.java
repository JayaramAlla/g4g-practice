package Trees;
// INITIAL CODE
import java.util.Scanner;
import java.lang.*;
import java.lang.Integer;
import java.util.HashMap;

// A Binary Search Tree node


class Check_BST1 {
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
    public static void main(String args[]) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Check_BST ob = new Check_BST();
        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();

            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null) {
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
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
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
    static class GfG {
        int isBST(Node root) {
            // Your code here
            return bstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        }

        int bstUtil(Node root, Integer min, Integer max) {
            if (root == null) {
                return 1;
            }
            if (root.data < min || root.data > max) {
                return 0;
            }
            int l = bstUtil(root.left, min, root.data);
            int r = bstUtil(root.right, root.data, max);
            if (l == 1 && r == 1) {
                return 1;
            }
            return 0;
        }

    }

}


