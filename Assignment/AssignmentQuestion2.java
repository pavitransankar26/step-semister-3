abstract class Assignment {
    String title;
    double maxMarks;
    int dueDay;

    Assignment(String title, double maxMarks, int dueDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
    }

    abstract double applyPenalty(double marks, int lateDays);
}

class CodingAssignment extends Assignment {

    CodingAssignment(String title, double maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    double applyPenalty(double marks, int lateDays) {
        return marks * Math.max(0, 1 - (0.10 * lateDays));
    }
}

class WrittenAssignment extends Assignment {

    WrittenAssignment(String title, double maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    double applyPenalty(double marks, int lateDays) {
        return marks * Math.max(0, 1 - (0.20 * lateDays));
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    int submissionDay;
    private String status = "Submitted";

    Submission(Student student, Assignment assignment, int submissionDay) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDay = submissionDay;

        int lateDays = Math.max(0, submissionDay - assignment.dueDay);

        if (lateDays == 0)
            System.out.println(student.name + "'s submission for '"
                    + assignment.title + "' received (on time).");
        else
            System.out.println(student.name + "'s submission for '"
                    + assignment.title + "' received ("
                    + lateDays + " days late).");

        System.out.println("Status: " + status);
    }

    void grade(double marks) {

        if (!status.equals("Submitted")) {
            System.out.println("Already graded.");
            return;
        }

        int lateDays = Math.max(0, submissionDay - assignment.dueDay);

        double finalMarks =
                assignment.applyPenalty(marks, lateDays);

        status = "Graded";

        System.out.printf("%s graded: %.0f/%.0f. Status: %s.%n",
                student.name,
                finalMarks,
                assignment.maxMarks,
                status);
    }

    void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '"
                    + assignment.title + "' has already been graded.");
        }
    }
}

public class AssignmentQuestion2 {
    public static void main(String[] args) {

        Assignment coding =
                new CodingAssignment("Linked List Lab", 50, 10);

        Assignment written =
                new WrittenAssignment("Design Essay", 50, 12);

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Submission s1 =
                new Submission(asha, coding, 10);

        Submission s2 =
                new Submission(ravi, written, 14);

        s1.grade(45);
        s2.grade(40);

        s1.resubmit();
    }
}
