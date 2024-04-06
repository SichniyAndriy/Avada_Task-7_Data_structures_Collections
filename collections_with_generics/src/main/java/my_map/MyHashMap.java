package my_map;

import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> implements MyMap<K, V> {
    @SuppressWarnings("unchecked")
    private Node<K, V>[] hashTable = (Node<K, V>[]) new Node[16];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {
        if (checkSize()) {
            Node<K, V> node = getNodeByKey(key);
            if (node == null) {
                putNewNode(new Node<>(key, value), hashTable);
                ++size;
            } else {
                node.value = value;
            }
        }
    }
    
    @Override
    public boolean remove(K key) {
        int index = Math.abs(Objects.hashCode(key)) % hashTable.length;
        if (hashTable[index] == null) {
            return false;
        } else if (hashTable[index].next == null) {
            hashTable[index] = null;
            --size;
            return true;
        } else {
            if (hashTable[index].key.equals(key)) {
                hashTable[index] = hashTable[index].next;
                --size;
                return true;
            } else {
                Node<K, V> prev = hashTable[index];
                Node<K, V> current = hashTable[index].next;
                while(current != null) {
                    if (current.key.equals(key)) {
                        prev.next = current.next;
                        --size;
                        return true;
                    }
                    prev = current;
                    current = current.next;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Node<K, V> node, tmp;
        for (var el: hashTable) {
            node = el;
            while (node != null) {
                tmp = node.next;
                node.next = null;
                --size;
                node = tmp;
            }
        }
        Arrays.fill(hashTable, null);
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNodeByKey(key);
        return node != null ? node.value : null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public K[] keyArray() {
        K[] arr = (K[]) new Object[size];
        int i = 0;
        Node<K, V> node;
        for (var el: hashTable) {
            node = el;
            while (node != null) {
                arr[i++] = (node.key);
                node = node.next;
            }
        }
        return arr;
    }

    @SuppressWarnings("unchecked")
    public V[] valueArray() {
        V[] arr = (V[]) new Object[size];
        int i = 0;
        Node<K, V> node;
        for (var el: hashTable) {
            node = el;
            while (node != null) {
                arr[i++] = node.value;
                node = node.next;
            }
        }
        return arr;
    }

    private boolean checkSize() {
        if (size > 2_000_000_000) {
            System.out.println("Max size");
            return false;
        } else if (size >= hashTable.length * 0.75) {
            resize();
        }
        return true;
    }

    private Node<K, V> getNodeByKey(K key) {
        int index = Math.abs(Objects.hashCode(key)) % hashTable.length;
        Node<K, V> node = hashTable[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
        
    private void putNewNode(Node<K,V> newNode, Node<K, V>[] table) {
        int index = Math.abs(Objects.hashCode(newNode.key)) % table.length;
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> node = table[index];
            while(node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] newHashTable = (Node<K, V>[]) new Node[hashTable.length << 1];
        realloc(newHashTable);
        Arrays.fill(hashTable, null);
        hashTable = newHashTable;
    }
    
    private void realloc(Node<K, V>[] newHashTable) {
        Node<K, V> node;
        for (var el: hashTable) {
            node = el;
            while(node != null) {
                Node<K, V> tmp = node.next;
                node.next = null;
                putNewNode(node, newHashTable);
                node = tmp;
            }
        }
    }
    
    private class Node<K, V> {
        private final int hash;
        private final K key;
        private V value;
        private Node<K, V> next;

        private Node(K k, V v) {
            key = k;
            value = v;
            hash = Objects.hashCode(key);
        }
    }
}
