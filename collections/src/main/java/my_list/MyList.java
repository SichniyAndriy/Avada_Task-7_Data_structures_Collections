package my_list;

public interface MyList {
    int size();

    boolean isEmpty();

    boolean contains(Integer obj);

    void add(Integer obj);

    void add(int index, Integer obj);

    boolean remove(Integer obj);

    void clear();

    Integer get(int index);

    int indexOf(Integer obj);

    int lastIndexOf(Integer obj);
}
