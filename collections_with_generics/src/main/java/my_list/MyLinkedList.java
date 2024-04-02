package my_list;

public class MyLinkedList<T> implements MyList<T> {
    Node start;
    Node end;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T t) {
        Node node = start;
        while (node != null) {
            if (node.value.equals(t)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void add(T t) {
        if (start == null) {
            start = end = new Node(t, null, null);
        } else {
            end.next = new Node(t, end, null);
            end = end.next;
        }
        ++size;
    }

    @Override
    public void add(int i, T t) {
        checkIndex(i);
        if (i == 0) {
            start.prev = new Node(t, null, start);
            start = start.prev;
        } else  {
            Node node = start;
            int j = 0;
            while(j < i) {
                node = node.next;
                ++j;
            }
            node.prev.next = new Node(t, node.prev, node);
            node.prev = node.prev.next;
        }
        ++size;
    }

    @Override
    public boolean remove(T t) {
        if (start.value.equals(t)) {
            start = start.next;
            --size;
        } else if (end.value.equals(t)) {
            end = end.prev;
            --size;
        } else {
            Node prev = start;
            Node current = start.next;
            while (current != null) {
                if (current.value.equals(t)) {
                    prev.next = current.next;
                    current.next.prev = current.prev;
                    current.prev = current.next = null;
                    --size;
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Node node = start;
        Node tmp;
        start = end = null;
        while (node != null) {
            tmp = node;
            node = node.next;
            tmp.prev = null;
            tmp.next = null;
            --size;
        }
    }

    @Override
    public T get(int i) {
        checkIndex(i);
        int j = 0;
        Node node = start;
        while (j < i) {
            node = node.next;
            ++j;
        }
        return node.value;
    }

    @Override
    public int indexOf(T t) {
        Node node = start;
        int i = 0;
        while(node != null) {
            if (node.value.equals(t)) {
                return i;
            }
            node = node.next;
            ++i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T t) {
        Node node = end;
        int i = size - 1;
        while (node != null) {
            if (node.value.equals(t)) {
                return i;
            }
            node = node.prev;
            --i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node node = start;
        while(node != null) {
            stringBuilder.append(node.value).append(", ");
            node = node.next;
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.append("]").toString();
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException("!!!_ WRONG INDEX_ !!!");
        } else if (i > 2_000_000_000) {
            throw new ArrayStoreException("!!! _HEAP POLLUTION_ !!!");
        }
    }

    private class Node {
        T value;
        Node prev;
        Node next;

        private Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
