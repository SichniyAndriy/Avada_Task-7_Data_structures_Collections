package main.java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer x = Integer.MAX_VALUE + 1;
        System.out.println(x);
        char[] chXArr = Integer.toBinaryString(x).toCharArray();
        System.out.println(chXArr.length + " " + Arrays.toString(chXArr));

        Integer y = -1;
        char[] chYArr = Integer.toBinaryString(y).toCharArray();
        System.out.println(chYArr.length + " " + Arrays.toString(chYArr));

        Integer z = 1 << 30;
        char[] chZArr = Integer.toBinaryString(z).toCharArray();
        System.out.println(chZArr.length + " " + Arrays.toString(chZArr) + " " + z);

//        for (int i = y; i > -256 ; --i) {
//            System.out.print(i + "\t- ");
//            syArr = Integer.toBinaryString(i).toCharArray();
//            System.out.println(Arrays.toString(syArr));
//        }
    }
}
