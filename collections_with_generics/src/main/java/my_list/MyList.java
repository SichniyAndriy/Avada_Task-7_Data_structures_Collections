package my_list;

public interface MyList<T> {
    int size();

    boolean isEmpty();

    boolean contains(T t);

    void add(T t);

    void add(int i, T t);

    boolean remove(T t);

    void clear();

    T get(int i);

    int indexOf(T t);

    int lastIndexOf(T t);
}
