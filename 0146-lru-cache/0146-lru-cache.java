class LRUCache {
        class Node{
            int key;
            int val;
            Node next;
            Node prev;
            Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
        Node head = new Node(-1,-1);
        Node tail = new Node(-1,-1);

        int cap;
        HashMap<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public void addNode(Node node){
        Node temp = head.next;
        node.prev = head;
        node.next = temp;
        head.next = node;
        temp.prev = node;
    }
    
    public void deleteNode(Node node){
        Node delPrev = node.prev;
        Node delNext = node.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int res = resNode.val;
            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            map.put(key,head.next);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            map.remove(key);
            deleteNode(resNode);
        }
        if(map.size() == cap){
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
        }
        addNode(new Node(key,value));
        map.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */