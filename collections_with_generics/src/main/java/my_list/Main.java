package my_list;

import main.java.Person;
import net.datafaker.Faker;

public class Main {
    private static final Faker faker = new Faker();

    public static void main(String[] args) {
       testMyArrayList();
       testMyLinkedList();
    }

    private static void testMyLinkedList() {
        MyList<Person> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 5; ++i) {
            Person person = new Person(
                    faker.idNumber().peselNumber(),
                    faker.name().fullName(),
                    faker.random().nextInt(15, 75)
            );
            myLinkedList.add(person);
        }

        for (int i = 0; i < 3; ++i) {
            Person person = new Person(
                    faker.idNumber().peselNumber(),
                    faker.name().fullName(),
                    faker.random().nextInt(15, 75)
            );
            myLinkedList.add(faker.random().nextInt(myLinkedList.size() - 1), person);
        }

        Person person;
        int index;
        person = myLinkedList.get(0);
        myLinkedList.remove(person);
        index = faker.random().nextInt(0, myLinkedList.size() - 1);
        person = myLinkedList.get(index);
        myLinkedList.remove(person);
        index = faker.random().nextInt(0, myLinkedList.size() - 1);
        person = myLinkedList.get(index);
        myLinkedList.remove(person);
        person = myLinkedList.get(myLinkedList.size() - 1);
        myLinkedList.remove(person);

        myLinkedList.clear();
    }

    private static void testMyArrayList() {
        MyList<Person> myArrayList = new MyArrayList<>(Person.class);
        for (int i = 0; i < 15; ++i) {
            Person person = new Person(
                    faker.idNumber().peselNumber(),
                    faker.name().fullName(),
                    faker.random().nextInt(15, 75)
            );
            myArrayList.add(person);
        }

        for (int i = 0; i < 10; ++i) {
            Person person = new Person(
                    faker.idNumber().peselNumber(),
                    faker.name().fullName(),
                    faker.random().nextInt(15, 75)
            );
            myArrayList.add(faker.random().nextInt(myArrayList.size() * 2), person);
        }

        for (int i = 0; i < 3; ++i) {
            Person person = myArrayList.get(faker.random().nextInt(myArrayList.size()) - 1);
            myArrayList.remove(person);
        }

        myArrayList.clear();
    }
}
