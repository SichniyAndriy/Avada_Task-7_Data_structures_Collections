package my_list;

import net.datafaker.Faker;

public class Main {
    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        checkMyArrayList();
        //checkMyLinkedList();
    }

    private static void checkMyArrayList(){
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 15; ++i) {
            myArrayList.add(i + 1);
        }

        System.out.println(myArrayList);
        myArrayList.add(20, faker.random().nextInt());
        System.out.println(myArrayList);
        myArrayList.add(30, faker.random().nextInt());
        System.out.println(myArrayList);

        for (int i = 0; i < 10; ++i) {
            myArrayList.add(faker.random().nextInt(myArrayList.size()), (i + 1) * 10);
        }
        System.out.println(myArrayList);

        myArrayList.remove(2);
        System.out.println(myArrayList);
        myArrayList.remove(8);
        System.out.println(myArrayList);
        myArrayList.remove(14);
        System.out.println(myArrayList);
        myArrayList.remove(105);
        System.out.println(myArrayList);
    }

    private static void checkMyLinkedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 10; ++i) {
            myLinkedList.add(i);
        }

        System.out.println(myLinkedList);

        myLinkedList.add(3, faker.random().nextInt(50, 150));
        System.out.println(myLinkedList);
        myLinkedList.add(0, faker.random().nextInt(50, 150));
        System.out.println(myLinkedList);
        myLinkedList.add(-25, faker.random().nextInt(50, 150));
        System.out.println(myLinkedList);
        myLinkedList.add(25, faker.random().nextInt(50, 150));
        System.out.println(myLinkedList);
        myLinkedList.remove(5);
        System.out.println(myLinkedList);
        myLinkedList.clear();
        System.out.println(myLinkedList);
    }
}
