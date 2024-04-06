package my_map;

import net.datafaker.Faker;

public class Main {
    private final static Faker faker = new Faker();

    public static void main(String[] args) {
        MyMap<Long, String> myHashMap = new MyHashMap<>();

        for (int i = 0; i < 5; i++) {
            myHashMap.put(faker.barcode().gtin14(), faker.starWars().character());
            myHashMap.put(faker.barcode().gtin14(), faker.stargate().characters());
            myHashMap.put(faker.barcode().gtin14(), faker.bigBangTheory().character());
            myHashMap.put(faker.barcode().gtin14(), faker.backToTheFuture().character());
        }

        Object[] keys = myHashMap.keyArray();
        Object[] values = myHashMap.valueArray();

        for (int i = 0; i < 3; i++) {
            myHashMap.put(
                    (Long) keys[faker.random().nextInt(keys.length)],
                    (String) values[faker.random().nextInt(values.length)]
            );
        }

        for (int i = 0; i < 3; ++i) {
            myHashMap.remove((Long) keys[faker.random().nextInt(keys.length)]);
        }

        myHashMap.clear();
    }
}
