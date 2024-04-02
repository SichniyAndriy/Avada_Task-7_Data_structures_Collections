package my_list;

import lombok.AllArgsConstructor;
import net.datafaker.Faker;

public class Main {
    private static final Faker faker = new Faker();

    public static void main(String[] args) {
       testMyArrayList();
    }

    static void testMyArrayList() {
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

@AllArgsConstructor
class Person {
    String id;
    String name;
    Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
