// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

// Subscribe to see which companies asked this question

// Hide Tags Design

public class LRUCache {
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    } 
    
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        // if the current node was called, it should be moved to the tail since it's recently used
        Node curr = map.get(key);
        int result = curr.val;
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        moveToTail(curr);
        return result;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) { // should not just write map.containsKey(key) since once update the value, the node is called thereby should move from the current position to the tail. Call get function can do both check if key is there and move the node to the tail and delete the current position
            map.get(key).val = value;
            return;
        }
        
        Node curr = new Node(key, value);
        int size = map.size();
        // delete first node
        if (size == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        // append the node to tail
        moveToTail(curr);
        map.put(key, curr);
        return;
    }
    
    public void moveToTail (Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}