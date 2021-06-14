package lesson1;

public class Cat {
    private  final int catMayRun = 200;
    private final  float catMayJump = 2;


    public Cat() {

    }


    void run(Treadmill distance) {
        if ((distance.getDistance() > catMayRun) || (distance.getDistance() <= 0)) {
            System.out.println("Котик не осилил дистанцию");
        } else {
            System.out.println("Кот пробежал " + distance.getDistance() + " метров");
        }
    }


    void jumpOver(Wall barrier) {
        if ((barrier.getHigh() > catMayJump) || (barrier.getHigh() <=0)) {
            System.out.println("Котейка не смог перепрыгнуть препятствие высотой в " + barrier.getHigh() + " м");
        } else {
            System.out.println("Котик смог перепрыгнуть препятствие высотой в " + barrier.getHigh() + " м");
        }
    }
}
