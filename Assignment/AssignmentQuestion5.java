import java.util.*;

interface NotificationChannel {
    void send(Student student, String message);
}

class EmailChannel implements NotificationChannel {

    public void send(Student student, String message) {
        System.out.println("[Email → "
                + student.name + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {

    public void send(Student student, String message) {
        System.out.println("[SMS → "
                + student.name + "] " + message);
    }
}

class AppChannel implements NotificationChannel {

    public void send(Student student, String message) {
        System.out.println("[App → "
                + student.name + "] " + message);
    }
}

class Student {
    String name;
    String department;
    ArrayList<NotificationChannel> channels =
            new ArrayList<>();

    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}

class Notice {
    String title;
    ArrayList<String> departments;

    Notice(String title, ArrayList<String> departments) {
        this.title = title;
        this.departments = departments;
    }

    boolean isValid() {
        return title != null &&
               !title.trim().isEmpty() &&
               departments != null &&
               !departments.isEmpty();
    }
}

class NoticeBoard {
    ArrayList<Student> students =
            new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    void postNotice(Notice notice) {

        if (!notice.isValid()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.title
                + "' posted to " + String.join(", ",
                notice.departments) + ".");

        for (Student student : students) {

            if (notice.departments.contains(student.department)) {

                for (NotificationChannel channel :
                        student.channels) {

                    channel.send(student, notice.title);
                }
            }
        }
    }
}

public class AssignmentQuestion5 {
    public static void main(String[] args) {

        Student asha =
                new Student("Asha", "CSE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student ravi =
                new Student("Ravi", "ECE");

        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();

        board.addStudent(asha);
        board.addStudent(ravi);

        ArrayList<String> cse = new ArrayList<>();
        cse.add("CSE");

        Notice notice1 =
                new Notice("Lab Closed Tomorrow", cse);

        board.postNotice(notice1);

        ArrayList<String> departments =
                new ArrayList<>();

        departments.add("CSE");
        departments.add("ECE");

        Notice notice2 =
                new Notice("Fee Deadline Extended",
                        departments);

        board.postNotice(notice2);

        ArrayList<String> empty =
                new ArrayList<>();

        Notice notice3 =
                new Notice("Sports Day", empty);

        board.postNotice(notice3);
    }
}
