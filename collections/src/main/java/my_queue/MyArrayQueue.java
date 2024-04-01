package my_queue;

public class MyArrayQueue implements MyQueue {
    Integer[] arr;
    private int size = 0;

    public MyArrayQueue() {
        this(10);
    }

    public MyArrayQueue(int n) {
        arr = new Integer[n];
    }

    @Override
    public boolean offer(Integer obj) {
        if (size < arr.length) {
            arr[size++] = obj;
            return true;
        }
        return false;
    }

    @Override
    public Integer poll() {
        Integer tmp = null;
        if (size > 0) {
            tmp = arr[0];
            System.arraycopy(arr, 1, arr, 0, --size);
            arr[size] = null;
        }
        return tmp;
    }

    @Override
    public Integer peek() {
        if (size > 0) {
            return arr[0];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        if (size == 0) {
            return stringBuilder.append("]").toString();
        }

        for (var el: arr) {
            if(el != null) {
                stringBuilder.append(el).append(", ");
            }
        }
        return stringBuilder
                .delete(stringBuilder.length() - 2, stringBuilder.length())
                .append("]")
                .toString();
    }
}
