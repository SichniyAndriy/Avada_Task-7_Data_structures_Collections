package my_map;

import net.datafaker.Faker;

public class Main {
    private final static Faker faker = new Faker();

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        for (int i = 0; i < 20; ++i) {
            myHashMap.put(faker.starWars().character(), Integer.valueOf(faker.aws().accountId()));
            myHashMap.put(faker.starWars().droids(), Integer.valueOf(faker.aws().accountId()));
            myHashMap.put(faker.starWars().planets(), Integer.valueOf(faker.aws().accountId()));
            myHashMap.put(faker.starWars().vehicles(), Integer.valueOf(faker.aws().accountId()));
        }

        String[] arr = myHashMap.keyArray();
        for (int i = 0; i < 8; ++i) {
            myHashMap.remove(arr[faker.random().nextInt(arr.length)]);
        }

        myHashMap.clear();
    }
}
