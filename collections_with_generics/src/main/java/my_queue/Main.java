package my_queue;

import main.java.Person;
import net.datafaker.Faker;

public class Main {
    private final static Faker faker = new Faker();

    public static void main(String[] args) {
        MyQueue<Person> myArrayQueue = new MyLinkedQueue<>(Person.class);
        for (int i = 0; i < 11; ++i) {
            Person person = new Person(
                    faker.idNumber().ssnValid(),
                    faker.name().fullName(),
                    faker.random().nextInt(15, 75)
            );
            myArrayQueue.offer(person);
            System.out.println("\n" + myArrayQueue);
        }

        System.out.println("\n" + myArrayQueue.peek());

        for (int i = 0; i < 5; ++i) {
            myArrayQueue.poll();
        }
        System.out.println(myArrayQueue);
    }
}
