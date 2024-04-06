package my_list;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList implements MyList {
    private Integer[] arr = new Integer[10];
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
        for (var num: arr) {
            if (Objects.equals(num, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Integer obj) {
        if (checkPlace()) {
            arr[size++] = obj;
        }
    }

    @Override
    public void add(int index, Integer obj) {
        if (index < 0 || !checkPlace())  return;

        int i = Math.min(index, size);
        System.arraycopy(arr, i, arr, i + 1, size - i);
        arr[i] = obj;
        ++size;
    }

    @Override
    public boolean remove(Integer obj) {
        int index = -1;
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(arr[i], obj)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
            arr[--size] = null;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(arr, null);
        arr = new Integer[10];
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return arr[index];
    }

    @Override
    public int indexOf(Integer obj) {
        for (int i = 0; i < arr.length; ++i) {
            if (Objects.equals(arr[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer obj) {
        for (int i = arr.length - 1; i >= 0 ; --i) {
            if (Objects.equals(arr[i], obj)) {
                return i;
            }
        }
        return -1;
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

    //------------------------------ PRIVATE ------------------------------\\
    private boolean checkPlace() {
        if (size > 1_000_000_000) {
            System.out.println("Досягнуто ліміт значень");
            return false;
        } else if (size == arr.length) {
            resize();
            return true;
        } else {
            return true;
        }
    }
    private void resize() {
        Integer[] newArr = new Integer[size << 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }


}
