package lesson41;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private String name;
    private String phone;
    HashMap<String, String> book = new HashMap<>();

    Phonebook () {

    }

    public void add (String phone, String name) {
       book.put(phone, name);
    }

    public String get(String name){
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> el : book.entrySet()) {
            if (el.getValue().equals(name)) {
                //System.out.println(el.getKey() + " " + el.getValue());
                s.append(el.getKey()).append(" ");
            }
        }

        return name + " " + s;

    }

}
