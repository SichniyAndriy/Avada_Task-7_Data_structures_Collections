package my_queue;

public interface MyQueue {
    boolean offer(Integer obj);

    Integer poll();

    Integer peek();
}
