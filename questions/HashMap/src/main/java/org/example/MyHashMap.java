package org.example;

public class MyHashMap<K, V> {
    public static final int INITIAL_CAPACITY = 1<<4;
    public static final int MAXIMUM_CAPACITY = 1<<30;

    public Entry[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_CAPACITY];
    }
    public MyHashMap(int capacity) {
        int tableSize = getTableSize(capacity);
        hashTable = new Entry[tableSize];
    }

    // 2^s >= capacity
    // s * log(2) >= log(capacity)
    // s >= log(capacity) / log(2)
    private int getTableSize(int capacity) {
        if (capacity >= MAXIMUM_CAPACITY) {
            return MAXIMUM_CAPACITY;
        }
        int s = (int) (Math.log(capacity) / Math.log(2));
        return Math.pow(2, capacity) == capacity ? capacity : (int) Math.max(Math.pow(2, s + 1), MAXIMUM_CAPACITY);
    }

    private class Entry<K, V> {
        public K key;
        public V value;
        public Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //--------------------------MAP FUNCTIONS--------------------------

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if (node == null) {
            hashTable[hashCode] = new Entry(key, value);
        } else {
            while (node.next != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            node.next = new Entry(key, value);
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while (node != null) {
            if (node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    public int size() {
        return hashTable.length;
    }
}
