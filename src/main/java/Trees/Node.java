package Trees;

public class Node
{
    int data,hd;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}
