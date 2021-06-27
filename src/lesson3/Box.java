package lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Fruit> {


    private List<T> box = new ArrayList<>();
    public void boxAddFruit(T fruit) {
            box.add(fruit);
    }


    public float getWeight() {
        float boxWeight = 0;
        for (T fruit : box) {
            boxWeight += fruit.getFruitWeight();
        }
        return boxWeight;
    }

    public boolean compare (Box box) {
        return this.getWeight() - box.getWeight() == 0;

    }

    public void transferToAnotherBox(Box<T> fromBox) {

        if (this != fromBox) {
            this.box.addAll(fromBox.box);
            fromBox.box.clear();
        } else {
            System.out.println("This is the same box! The amount does not change!");
        }

    }

}
