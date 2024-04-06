package my_list;

import net.datafaker.Faker;

public class Main {
    private static final Faker faker = new Faker();

    public static void main(String[] args) {
       testMyArrayList();
       testMyLinkedList();
    }

    private static void testMyLinkedList() {
        MyList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 5; ++i) {
            myLinkedList.add(faker.random().nextInt());
        }

        for (int i = 0; i < 3; ++i) {

            myLinkedList.add(faker.random().nextInt(myLinkedList.size() - 1), faker.random().nextInt());
        }

        int index;
        int x = myLinkedList.get(0);
        myLinkedList.remove(x);
        index = faker.random().nextInt(0, myLinkedList.size() - 1);
        x = myLinkedList.get(index);
        myLinkedList.remove(x);
        index = faker.random().nextInt(0, myLinkedList.size() - 1);
        x = myLinkedList.get(index);
        myLinkedList.remove(x);
        index = faker.random().nextInt(0, myLinkedList.size() - 1);
        x = myLinkedList.get(index);
        myLinkedList.remove(x);

        myLinkedList.clear();
    }

    private static void testMyArrayList() {
        MyList myArrayList = new MyArrayList();
        for (int i = 0; i < 15; ++i) {
            myArrayList.add(faker.random().nextInt());
        }

        for (int i = 0; i < 10; ++i) {
            int index = faker.random().nextInt(myArrayList.size() * 2);
            myArrayList.add(index, faker.random().nextInt());
        }

        for (int i = 0; i < 3; ++i) {
            int x = myArrayList.get(faker.random().nextInt(myArrayList.size()) - 1);
            myArrayList.remove(x);
        }

        myArrayList.clear();
    }
}
