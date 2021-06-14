package lesson1;

public class Main {
    public static void main(String[] args){

        Object[] participants = new Object[]{
               new Cat(),
               new Human(),
               new Robot()
        };

        Object[] obstacles = new Object[]{
                new Wall(2),
                new Treadmill(50),
                new Wall(10)
        };

        for (int i = 0; i < participants.length; i++) {
            Object participant = participants[i];
            if (participants[i] instanceof Robot) {
              Robot robot = (Robot) participant;
            }
            for (int j = 0; j < obstacles.length; j++) {
                if (participants[i] instanceof Robot) {
                    Robot robot = (Robot) participant;
                    if (obstacles[j] instanceof Wall){
                        robot.jumpOver((Wall)obstacles[j]);
                    }
                    if (obstacles[j] instanceof Treadmill){
                        robot.run((Treadmill) obstacles[j]);
                    }
                }
                if (participants[i] instanceof Cat) {
                    Cat cat = (Cat) participant;
                    if (obstacles[j] instanceof Wall){
                        cat.jumpOver((Wall)obstacles[j]);
                    }
                    if (obstacles[j] instanceof Treadmill){
                        cat.run((Treadmill) obstacles[j]);
                    }
                }
                if (participants[i] instanceof Human) {
                    Human human = (Human) participant;
                    if (obstacles[j] instanceof Wall){
                        human.jumpOver((Wall)obstacles[j]);
                    }
                    if (obstacles[j] instanceof Treadmill){
                        human.run((Treadmill) obstacles[j]);
                    }
                }
            }
        }


//        Cat cat = new Cat();
//        cat.run(new Treadmill(50));
//        cat.jumpOver(new Wall(2));
//
//
//
//        Human human = new Human();
//        human.run(new Treadmill(100));
//        human.jumpOver(new Wall(5));
//
//        Robot robot = new Robot();
//        robot.run(new Treadmill(700));
//        robot.jumpOver(new Wall(10));


    }
}
