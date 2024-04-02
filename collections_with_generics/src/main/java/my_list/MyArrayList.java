package my_list;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    T[] arr;
    private Class<T> type;
    private int size = 0;

    public MyArrayList(Class<T> tClass) {
        type = tClass;
        arr = (T[]) Array.newInstance(type, 10);
    }

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
        for (T el: arr) {
            if (el.equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T t) {
        if (checkPlace()) {
            arr[size++] = t;
        }
    }

    @Override
    public void add(int i, T t) {
        if (i < 0 || i > size) {
            add(t);
            return;
        }
        if (checkPlace()) {
            System.arraycopy(arr, i, arr, i + 1, size - i);
            arr[i] = t;
            ++size;
        }
    }

    @Override
    public boolean remove(T t) {
        int i = indexOf(t);
        if (i != -1) {
            System.arraycopy(arr, i + 1, arr, i, --size - i);
            arr[size] = null;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(arr, null);
        arr = (T[]) Array.newInstance(type, 10);
        size = 0;
    }

    @Override
    public T get(int i) {
        return arr[i];
    }

    @Override
    public int indexOf(T t) {
        for (int i = 0; i < arr.length; ++i) {
            if(arr[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T t) {
        for (int i = arr.length - 1; i >= 0 ; --i) {
            if (arr[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (T el: arr) {
            stringBuilder.append(el.toString()).append("\n");
        }
        return stringBuilder.append("]").toString();
    }

    private boolean checkPlace() {
        if (arr.length > 1_000_000_000) {
            System.out.println("Max size reached");
            return false;
        } else if (size == arr.length) {
            resize();
        }
        return true;
    }

    private void resize() {
        T[] newArr = (T[]) Array.newInstance(type, arr.length << 1);
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }
}
