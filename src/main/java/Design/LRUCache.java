package Design;

import java.util.HashMap;

class LRUCache {
    
    int size ;
    HashMap<Integer,Node> map ;
    
    Node head;
    Node end;
    
    
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0,0);
        end = new Node(0,0);
        head.post = end;
        end.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addNode(node);    
        
        return node.value;
    }
    /*
    ["LRUCache","put","put","get","get","put","get","get","get"]
[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
map = 2,3
head = 3->2
end = 2

    */
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            removeNode(node);
        }else{
            if(size == map.size()){
                map.remove(end.pre.key);
                removeNode(end.pre);
            }
            node = new Node(key,value);
            map.put(key, node);
        }
        addNode(node);
        
    }
    
    private void addNode(Node node){
        node.post = head.post;
        node.pre = head;
        head.post.pre = node;  
        head.post = node;
        
    }
    
    private void removeNode(Node node){//3
        // System.out.print(node.value+",");
        Node prev = node.pre;//null
        Node post = node.post;//2
        post.pre = prev; 
        prev.post = post;
        node.pre = null;
        node.post = null;
    }
    
    public static class Node{
        int key,value;
        Node pre;
        Node post;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */