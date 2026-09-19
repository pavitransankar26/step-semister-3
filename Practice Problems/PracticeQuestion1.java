abstract class Toy {
    static int count = 1000;
    final String toyId;
    String name;

    public Toy(String name) {
        count++;
        toyId = "TOY-" + count;
        this.name = name;
    }

    public abstract String makeSound();

    String getToyId() {
        return toyId;
    }
}

class ToyCar extends Toy {

    public ToyCar(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {

    public ToyRobot(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class PracticeQuestion1 {
    public static void main(String[] args) {

        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}
