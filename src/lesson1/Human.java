package lesson1;

public class Human{
    private  final int humanMayRun = 200;
    private final  float humanMayJump = 2;


    public Human() {

    }


    void run(Treadmill distance) {
        if ((distance.getDistance() > humanMayRun) || (distance.getDistance() <= 0)) {
            System.out.println("Человек не осилил дистанцию");
        } else {
            System.out.println("Человек пробежал " + distance.getDistance() + " метров");
        }
    }


    void jumpOver(Wall barrier) {
        if ((barrier.getHigh() > humanMayJump) || (barrier.getHigh() <= 0)) {
            System.out.println("Человек не смог перепрыгнуть препятствие высотой в " + barrier.getHigh() + " м");
        } else {
            System.out.println("Человек смог перепрыгнуть препятствие высотой в " + barrier.getHigh() + " м");
        }
    }
}
