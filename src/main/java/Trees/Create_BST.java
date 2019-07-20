package Trees;

//Initial Template for Java
/*package whatever //do not write package name here */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Create_BST {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST1(arr);
            preorder(tree);
            System.out.println();
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    /*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*
The structure of the Node is as follows:
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
    private static class GFG {

        

        public Node constructBalancedBST(int[] arr){
            //Write your code here and return the root of the constructed BST
            if(arr.length == 0){
                return null;
            }

            Arrays.sort(arr);
            //for(int i =0;i< arr.length;i++){
            //    System.out.print(arr[i]+",");
            //}
            //System.out.println(arr);
            return constructBalancedBST(arr,0,arr.length-1);
        }

        public Node constructBalancedBST(int[] arr, int start, int end){
            if(start > end){
                return null;
            }
            int mid = (start + end)/2;
            Node node = new Node(arr[mid]);
            node.left = constructBalancedBST(arr, start, mid-1);
            node.right = constructBalancedBST(arr, mid+1,end);
            return node;
        }

        public Node constructBST1(int[] arr){
            //Write your code here and return the root of the constructed BST

            if(arr.length==0)
                return null;

            Queue<NodeDetails> queue = new LinkedList<NodeDetails>();
            Node root = new Node(arr[0]);
            NodeDetails nd=new NodeDetails();
            nd.node = root;
            nd.min=Integer.MIN_VALUE;
            nd.max=Integer.MAX_VALUE;

            queue.offer(nd);

            Node node = root;

            int index = 1;
            while(!queue.isEmpty()){
                nd = queue.poll();
                root = nd.node;
                if(index<arr.length && arr[index]<nd.node.data && arr[index]>nd.min){
                    root.left=new Node(arr[index]);
                    NodeDetails nd1=new NodeDetails();
                    nd1.node = root.left;
                    nd1.max = root.data;
                    nd1.min = nd.min;
                    index++;
                    queue.offer(nd1);
                }

                if(index<arr.length && arr[index]>nd.node.data && arr[index]<nd.max){
                    root.right=new Node(arr[index]);
                    NodeDetails nd1=new NodeDetails();
                    nd1.node = root.right;
                    nd1.min = root.data;
                    nd1.max = nd.max;
                    index++;
                    queue.offer(nd1);
                }
            }

            return node;
        }

    }


    static class NodeDetails{
        Node node;
        int min,max;
        public NodeDetails(){

        }
        public NodeDetails(Node node, int min,int max){
            this.node=node;
            this.min=min;
            this.max=max;
        }
    }
}


