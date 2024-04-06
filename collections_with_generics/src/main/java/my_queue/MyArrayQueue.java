package my_queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayQueue<T> implements MyQueue<T> {
    T[] arr;
    private int size = 0;

    public MyArrayQueue(Class<T> tClass) {
        arr = (T[]) Array.newInstance(tClass, 10);
    }

    @Override
    public boolean offer(T t) {
        if (size < arr.length) {
            arr[size++] = t;
            return true;
        }
        return false;
    }

    @Override
    public T poll() {
        if (size > 0) {
            T t = arr[0];
            System.arraycopy(arr, 1, arr, 0, --size);
            arr[size] = null;
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        if (size > 0) {
            return arr[0];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (T el: arr) {
            if (el != null) {
                stringBuilder.append(el).append(",\n");
            }
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.append("]").toString();
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
