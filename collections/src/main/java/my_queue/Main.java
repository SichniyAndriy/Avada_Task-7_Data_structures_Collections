package my_queue;

public class Main {
    public static void main(String[] args) {
        MyArrayQueue myArrayQueue = new MyArrayQueue();

        for (int i = 0; i < 11; ++i) {
            myArrayQueue.offer(i + 1);
        }
        System.out.println(myArrayQueue);
        System.out.println("Peek: " + myArrayQueue.peek());
        System.out.println("Poll: " + myArrayQueue.poll());
        System.out.println("Poll: " + myArrayQueue.poll());
        System.out.println("Poll: " + myArrayQueue.poll());
        System.out.println("Poll: " + myArrayQueue.poll());
        System.out.println("Poll: " + myArrayQueue.poll());
        System.out.println(myArrayQueue);
    }
}
