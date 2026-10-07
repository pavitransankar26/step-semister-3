abstract class WashType {
    abstract int getDuration();
    abstract double getCharge();
}

class QuickWash extends WashType {
    int getDuration() {
        return 30;
    }

    double getCharge() {
        return 20;
    }
}

class NormalWash extends WashType {
    int getDuration() {
        return 45;
    }

    double getCharge() {
        return 30;
    }
}

class HeavyWash extends WashType {
    int getDuration() {
        return 60;
    }

    double getCharge() {
        return 45;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class WashingMachine {
    String id;
    private boolean busy = false;

    WashingMachine(String id) {
        this.id = id;
    }

    boolean isBusy() {
        return busy;
    }

    WashCycle startWash(Student student, WashType type) {
        if (busy) {
            System.out.println("Machine " + id + " is currently busy.");
            return null;
        }

        busy = true;

        WashCycle cycle = new WashCycle(student, this, type);

        System.out.println(type.getClass().getSimpleName()
                + " started on " + id + " for " + student.name
                + " (" + type.getDuration() + " min).");

        System.out.printf("Charge: ₹%.2f%n", type.getCharge());

        return cycle;
    }

    void completeWash() {
        busy = false;
        System.out.println(id + " cycle completed.");
        System.out.println(id + " is now free.");
    }
}

class WashCycle {
    Student student;
    WashingMachine machine;
    WashType type;

    WashCycle(Student student, WashingMachine machine, WashType type) {
        this.student = student;
        this.machine = machine;
        this.type = type;
    }
}

public class AssignmentQuestion1 {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.startWash(asha, new QuickWash());

        m1.startWash(ravi, new HeavyWash());

        m2.startWash(ravi, new HeavyWash());

        m1.completeWash();

        m1.startWash(neha, new NormalWash());
    }
}
