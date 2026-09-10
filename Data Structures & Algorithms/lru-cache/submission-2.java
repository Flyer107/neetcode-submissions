class LRUCache {

    private final Map<Integer, Integer> cache;
    private final int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        // capacity=# buckets to pre-allocate
        // 0.75f= load factor. When the map's size exceeds capacity * loadFactor. It resizes (rehashes). so 0.75 is a good defaultstandard between space and lookup sppeed
        // true=access-order flag. false:map keeps entires in insertion order; true: every time you GET or PUT an existing key, that entry is moved to the end of internal linkedlist so ordering becomes LRU -> MRU.
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) { // Anonymous inner class. Subclassing LinkedHashMap and overriding one method without naming the calss
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }

    /*Honestly did not know this data strcture existed.
    
    Time: O(1) for each put and get operation
    Space: O(n) because of the hashmap
    The LinkedHashMap constructor
new LinkedHashMap<>(capacity, 0.75f, true)
LinkedHashMap has a constructor with three parameters:

capacity — initial capacity (how many buckets to pre-allocate). Here you're passing the LRU capacity, which is a reasonable estimate since the map will hold at most that many entries. (In the reference solution this doesn't matter; it's just an optimization hint.)

0.75f — the load factor. When the map's size exceeds capacity * loadFactor, it resizes (rehashes). 0.75 is the standard default — a good tradeoff between space and lookup speed. Again, just a hint.

true — the access-order flag. This is the key one.

If false (default): the map keeps entries in insertion order.
If true: every time you get or put an existing key, that entry is moved to the end of the internal linked list.
So the ordering becomes "least recently used → most recently used". The head is the LRU, the tail is the MRU. This is exactly the ordering you need for LRU.

The anonymous subclass
new LinkedHashMap<>(...) {
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > LRUCache.this.capacity;
    }
}
Everything in { ... } is an anonymous inner class — you're subclassing LinkedHashMap and overriding one method, without naming the class.

removeEldestEntry(Map.Entry eldest) is a hook that LinkedHashMap calls automatically after every put (and putAll). It returns a boolean:

true → evict the eldest entry (the head of the linked list).
false → keep everything.
Because your map is in access order, the head is the least recently used entry. So returning size() > capacity means: "once we exceed capacity, drop the LRU entry." Exactly LRU semantics.

LRUCache.this.capacity
Inside the anonymous class, capacity alone would ambiguously refer to the map's own capacity concept / fail to resolve cleanly. LRUCache.this.capacity explicitly refers to the outer class instance's capacity field. (Note: the constructor parameter capacity in the LinkedHashMap call is a different value — the initial bucket count, not your LRU limit.)

How the whole thing works
get(key) → calls cache.getOrDefault(key, -1). Because of accessOrder=true, a successful get moves that key to the tail (now MRU). ✔ updates recency.
put(key, value) → inserts/updates, moves key to the tail. Then removeEldestEntry fires; if size() > capacity, it evicts the head (LRU). ✔ insert + evict.
Your complexity notes
Correct:

Time: O(1) average for get and put — hash lookup, and the doubly-linked-list moves are O(1).
Space: O(capacity) — at most capacity entries.
LinkedHashMap internally maintains a doubly-linked list over its entries threaded through the hash table, which is why access-order bookkeeping is free relative to your own implementation.

One caveat for interviews
This is a valid, elegant solution, but many interviewers will not accept it for the LRU Cache problem, precisely because it hides the data-structure reasoning they're testing (hashmap + doubly-linked list). The reference solution builds the HashMap<Integer, Node> + doubly-linked list by hand. I'd recommend knowing both: this trick shows Java fluency, but be ready to implement the manual version on a whiteboard.
    */
}
