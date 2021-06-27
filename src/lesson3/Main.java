package lesson3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 100; i++) {
            orangeBox.boxAddFruit(new Orange());
        }

        for (int i = 0; i < 150; i++) {
            appleBox1.boxAddFruit(new Apple());
        }

        for (int i = 0; i < 49; i++) {
            appleBox2.boxAddFruit(new Apple());
        }
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(appleBox1.compare(orangeBox));
        appleBox2.transferToAnotherBox(appleBox1);
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());


    }

    public static <T extends Object> void changeElement(int src, int dest, T[] arr) {
        T destValue = arr[dest];

        arr[dest] = arr[src];
        arr[src] = destValue;
    }

}
