class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class DLL {
    Node head;
    Node tail;
    public DLL(){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addToFront(Node n){
        Node temp = head.next;
        head.next = n;
        n.next = temp;
        temp.prev = n;
        n.prev = head;
    }

    public Node removeLast(){
        Node temp = tail.prev;
        temp.prev.next = tail;
        tail.prev = temp.prev;
        return temp;
    }

    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    DLL cache;
    int capacity =0;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DLL();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        cache.remove(n);
        cache.addToFront(n);
        map.put(key,n);
        return n.value; 
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node n = new Node(key,value);
            if(map.size()>=capacity){
                Node removed = cache.removeLast();
                map.remove(removed.key);
            }
            cache.addToFront(n);
            map.put(key,n);
        }
        else {
            Node n = map.get(key);
            n.value = value;
            cache.remove(n);
            cache.addToFront(n);
            map.put(key,n);
        }
        
    }
}
