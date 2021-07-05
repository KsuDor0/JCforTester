package lesson41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    static HashMap<String,Integer> words = new HashMap<>();


    public static void main(String[] args) {
        String[] strArr = {"Cat", "Milk", "Dog", "Pups", "Baby", "Stone", "Smart", "Milk", "Symbol",
                            "Milk", "Crack", "Moon", "Baby", "Sun"};
        int count = 0;


        System.out.println("Всего слов в массиве - " + strArr.length);
        countWords(strArr);
        System.out.println("=====Уникальные слова в массиве====");
        for (Map.Entry<String, Integer> s: words.entrySet()) {
            if(s.getValue() == 1) {
                System.out.println(s.getKey());
                count++;
            }
        }

        System.out.println("Уникальных слов в массиве - " + count);

        System.out.println("=====Количество слов в массиве=====");



        for (Map.Entry<String, Integer> s: words.entrySet()) {

            System.out.println(s.getKey() + " - " + s.getValue());

        }

        System.out.println("===Телефонная книга==");
        Phonebook p = new Phonebook();

        p.add("111", "Ivan");
        p.add("121", "Fedor");
        p.add("777", "Ivan");
        p.add("151", "Oleg");
        p.add("161", "Dima");
        p.add("34", "Ivan");

        System.out.println(p.get("Ivan"));





    }


    public static void countWords(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                  count++;
                }
            }
             words.put(arr[i], count);
        }
    }
}
