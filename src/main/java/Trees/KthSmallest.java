package Trees;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
[5,3,6,2,4,null,null,1], k = 3
 */
class KthSmallest {
    public int value = -1;
    
    public int kthSmallest(Node root, int k) {
        value = -1;
        kthSmallestRecursive(root,k,0);
        return value;
    }
    
    public int kthSmallestRecursive(Node root,int k, int cur){//5
        if(root == null){
            return cur;
        }
        // call left;
        int left = kthSmallestRecursive(root.left,k,cur);
        if(left >= k){
            return left+1;
        }
        if(k == left + 1){
            value = root.data;
            return left+1;
        }
        return kthSmallestRecursive(root.right,k,left+1);
    }
    public int kthSmallestIterative(Node root, int k) {
        int count=0;
        int ksmall=Integer.MAX_VALUE;
        Node current=root;
        while(current!=null)
        {
            if(current.left==null)
            {
                count++;
                if(count==k)
                {ksmall=current.data;
                    break;
                }
                current=current.right;
            }
            else
            {
                Node prev=current.left;
                while(prev.right!=null&&prev.right!=current)
                    prev=prev.right;
                if(prev.right==null)
                {
                    prev.right=current;
                    current=current.left;
                }
                else
                {
                    prev.right=null;
                    count++;
                    if(count==k)
                    {ksmall=current.data;
                        break;
                    }
                    current=current.right;
                }
            }
        }

        return ksmall;

    }

    public int kthSmallestIterativeWithStack(Node root, int k) {
        LinkedList<Node> stack = new LinkedList<Node>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.data;
            root = root.right;
        }
    }
}