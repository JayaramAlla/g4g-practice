package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LevelOrderTraversalSpiralForm {
    /*
     * created by Jayaram on 14/08/19
     */

// A Binary Tree node

            // driver function to test the above functions
        public static void main(String args[])
        {

            // Input the number of test cases you want to run
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            //Node root=null;
            while (t > 0)
            {
                HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
                int n = sc.nextInt();
                Node root=null;
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

                Spiral g = new Spiral();
                g.printSpiral(root);
                System.out.println();
                t--;

            }
        }
    /*This is a function problem.You only need to complete the function given below*/
/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
    static class Spiral
    {
        void printSpiral(Node node)
        {
            // Your code here
            Queue<Node> que = new LinkedList<Node>();
            que.add(node);
            Stack<Node> stack = new Stack<Node>();
            int i = 0;
            while(!que.isEmpty()){
                int n= que.size();

                while(n-- > 0){
                    node = que.poll();
                    if(node.left != null)
                        que.add(node.left);
                    if(node.right != null)
                        que.add(node.right);
                    if(i%2 == 0){
                        stack.push(node);
                    }else {
                        System.out.print(node.data+" ");
                    }
                }
                while(i%2 == 0 && stack.size() > 0){
                    node = stack.pop();
                    System.out.print(node.data+" ");
                }
                i++;
            }
        }


        void printSpiralUsing2Stacks(Node node)
        {
            if (node == null)
                return; // NULL check

            // Create two stacks to store alternate levels
            // For levels to be printed from right to left
            Stack<Node> s1 = new Stack<Node>();
            // For levels to be printed from left to right
            Stack<Node> s2 = new Stack<Node>();

            // Push first level to first stack 's1'
            s1.push(node);

            // Keep printing while any of the stacks has some nodes
            while (!s1.empty() || !s2.empty()) {
                // Print nodes of current level from s1 and push nodes of
                // next level to s2
                while (!s1.empty()) {
                    Node temp = s1.peek();
                    s1.pop();
                    System.out.print(temp.data + " ");

                    // Note that is right is pushed before left
                    if (temp.right != null)
                        s2.push(temp.right);

                    if (temp.left != null)
                        s2.push(temp.left);
                }

                // Print nodes of current level from s2 and push nodes of
                // next level to s1
                while (!s2.empty()) {
                    Node temp = s2.peek();
                    s2.pop();
                    System.out.print(temp.data + " ");

                    // Note that is left is pushed before right
                    if (temp.left != null)
                        s1.push(temp.left);
                    if (temp.right != null)
                        s1.push(temp.right);
                }
            }
        }
    }

}
