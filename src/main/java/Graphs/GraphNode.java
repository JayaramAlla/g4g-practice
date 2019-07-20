package Graphs;

public class GraphNode {
    /*
     * created by Jayaram on 14/06/19
     */
    int data;
    GraphNode[] arry;
    public GraphNode(int data,int size){
        this.data = data;
        this.arry = new GraphNode[size];
    }
}
