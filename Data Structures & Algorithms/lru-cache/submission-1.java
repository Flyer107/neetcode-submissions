class LRUCache {
    private int cap;
    private Map<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        this.right.prev = left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;

        // previous node's next points to curr node's next to "skip over it"
        prev.next = nxt;
        // curr node's next points to curr node's prev to "skip over its"
        nxt.prev = prev;
    }

    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            
            return node.val;
        }
        return -1;
    }

    public void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;

        //right and left are nodes themselves
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)); // This removes the node
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > cap) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}

public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

/*
https://www.youtube.com/watch?v=7ABFKPK2hD4&t=1s
Explains how we have a hashmap to store the Key: int and value: node. While simultaneuously the nodes form a doubly linkedlist (key, val, prev, next).
Then on the outside we keep a left pointer to the LRU and a right pointer to the MRU (most recently used).
So you play with seitch ing those things around when removing.

Time: O(1) for each put and get operation
Space: O(n) because of the hashmap
*/
