package lesson1;

public class Robot {
    private  final int robotMayRun = 200;
    private final  float robotMayJump = 2;


    public Robot() {

    }

    void run(Treadmill distance) {
        if ((distance.getDistance() > robotMayRun) || (distance.getDistance()<= 0)) {
            System.out.println("Робот не осилил дистанцию");
        } else {
            System.out.println("Робот пробежал " + distance.getDistance() + " метров");
        }
    }


    void jumpOver(Wall barrier) {
        if ((barrier.getHigh() > robotMayJump) || (barrier.getHigh() <=0)) {
            System.out.println("Робот не смог перепрыгнуть препятствие высотой в " + barrier.getHigh() + " м");
        } else {
            System.out.println("Робот смог перепрыгнуть препятствие высотой в " + barrier.getHigh() + " м");
        }
    }
}
