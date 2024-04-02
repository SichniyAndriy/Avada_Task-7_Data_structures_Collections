package my_map;

import java.util.Arrays;
import java.util.Objects;

public class MyHashMap implements MyMap {
    private Node[] hashTable = new Node[16];
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
    public void put(String key, Integer value) {
        if (size == hashTable.length * 0.75) {
            resize();
        }
        Node node = getNodeByKey(key);
        if (node == null) {
            putNodeInHashTable(hashTable, new Node(key, value));
            ++size;
        } else {
            node.value = value;
        }
    }

    @Override
    public boolean remove(String key) {
        int index = Math.abs(Objects.hashCode(key)) % hashTable.length;
        if (hashTable[index] != null) {
            if (hashTable[index].next == null) {
                hashTable[index] = null;
            } else {
                if (hashTable[index].key.equals(key)) {
                    hashTable[index] = hashTable[index].next;
                } else {
                    Node prev = hashTable[index];
                    Node current = hashTable[index].next;
                    while(current != null) {
                        if (current.key.equals(key)) {
                            prev.next = current.next;
                        }
                        prev = current;
                        current = current.next;
                    }
                }

            }
            --size;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(hashTable, null);
        size = 0;
    }

    @Override
    public Integer get(String key) {
        for (var el: hashTable) {
            if (el != null) {
                Node node = el;
                while (node != null) {
                    if (node.key.equals(key)) {
                        return node.value;
                    }
                    node = node.next;
                }
            }
        }
        return null;
    }

    @Override
    public String[] keyArray() {
        String[] arr = new String[size];
        int i = 0;
        for (Node node: hashTable) {
            while (node != null) {
                arr[i++] = node.key;
                node = node.next;
            }
        }
        return arr;
    }

    @Override
    public Integer[] valueArray() {
        Integer[] arr = new Integer[size];
        int i = 0;
        for (Node node: hashTable) {
            while (node != null) {
                arr[i++] = node.value;
                node = node.next;
            }
        }
        return arr;
    }

    private void putNodeInHashTable(Node[] hashTable, Node node) {
        int index = Math.abs(node.hash) % hashTable.length;
        if (hashTable[index] == null) {
            hashTable[index] = node;
        } else {
            Node tmp = hashTable[index];
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    private Node getNodeByKey(String key) {
        int index = Math.abs(Objects.hashCode(key)) % hashTable.length;
        Node node = hashTable[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private void resize() {
        if (hashTable.length > 1_000_000_000) {
            System.out.println("Max size");
        }
        Node[] newHashTable = new Node[hashTable.length << 1];
        realloc(newHashTable);
    }

    private void realloc(Node[] newHashTable) {
        for (var el: hashTable) {
            if (el != null) {
                Node node = el;
                while (node != null) {
                    Node tmp = node.next;
                    node.next = null;
                    putNodeInHashTable(newHashTable, node);
                    node = tmp;
                }
            }
        }
        hashTable = newHashTable;
    }

    private class Node {
        private final String key;
        private Integer value;
        private final int hash;
        private Node next;

        private Node(String key, Integer value) {
            this.key = key;
            this.value = value;
            hash = Objects.hashCode(key);
        }
    }
}
