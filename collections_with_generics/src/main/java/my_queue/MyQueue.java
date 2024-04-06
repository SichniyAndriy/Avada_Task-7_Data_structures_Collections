package my_queue;

public interface MyQueue<T> {
    boolean offer(T t);

    T poll();

    T peek();
}
