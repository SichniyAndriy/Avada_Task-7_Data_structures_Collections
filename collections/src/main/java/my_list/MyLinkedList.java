package my_list;

import java.util.Objects;

public class MyLinkedList implements MyList {
    Node start;
    Node end;
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
    public boolean contains(Integer obj) {
        Node node = start;
        while (node != null) {
            if (Objects.equals(node.value, obj)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void add(Integer obj) {
        if (start == null) {
            start = end = new Node(obj, null, null);
        } else {
            end.next = new Node(obj, end, null);
            end = end.next;
        }
        ++size;
    }

    @Override
    public void add(int index, Integer obj) {
        if (index < 0 || index >= size) {
            add(obj);
        } else {
            Node node = start;
            int i = 0;
            while (i < index) {
                node = node.next;
                ++i;
            }
            if (node.prev == null) {
                node.prev = new Node(obj, null, node);
                start = node.prev;
            } else if (node.next == null) {
                node.next = new Node(obj, end, null);
                end = node.next;
            } else {
                node.prev.next = new Node(obj, node.prev, node);
                node.prev = node.prev.next;
            }
            ++size;
        }
    }

    @Override
    public boolean remove(Integer obj) {

        if (start.value.equals(obj)) {
            start = start.next;
        } else if (end.value.equals(obj)) {
            end = end.prev;
        } else {
            Node node = start.next;
            while (node != null) {
                if (node.value.equals(obj)) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    --size;
                    return true;
                }
                node = node.next;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        Node node = start;
        start = null;
        end = null;
        Node tmp;
        while (node != null) {
            tmp = node.next;
            node.next = null;
            node.prev = null;
            node = tmp;
            --size;
        }

    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) return null;
        Node node = start;
        int i = 0;
        while(i < index) {
            node = node.next;
            ++i;
        }
        return node.value;
    }

    @Override
    public int indexOf(Integer obj) {
        Node node = start;
        int i = 0;
        while(node != null) {
            if (node.value.equals(obj)) {
                return i;
            }
            node = node.next;
            ++i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer obj) {
        Node node = end;
        int i = size - 1;
        while(node != null) {
            if (node.value.equals(obj)) {
                return i;
            }
            node = node.prev;
            --i;
        }
        return -1;
    }

    private class Node {
        Integer value;
        Node prev;
        Node next;

        private Node(Integer value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node node = start;
        if (node == null) {
            return stringBuilder.append("]").toString();
        }
        while(node != null) {
            stringBuilder.append(node.value).append(", ");
            node = node.next;
        }
        return stringBuilder
                .delete(stringBuilder.length() - 2, stringBuilder.length())
                .append("]")
                .toString();
    }

}
