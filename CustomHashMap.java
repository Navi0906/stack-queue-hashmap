class CustomHashMap<K, V> {

    // Node class for linked list
    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final int SIZE = 16; // Default capacity
    private Node<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Insert key-value pair
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = buckets[index];

        // Check if key already exists, update value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert at the beginning
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // Get value by key
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // Not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets[index] = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    // Display the hashmap (for testing)
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            Node<K, V> head = buckets[i];
            System.out.print("Bucket " + i + ": ");
            while (head != null) {
                System.out.print("[" + head.key + " : " + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("apple", 100);
        map.put("banana", 200);
        map.put("cherry", 300);

        System.out.println("Get apple: " + map.get("apple"));
        map.remove("banana");
        map.display();
    }
}
