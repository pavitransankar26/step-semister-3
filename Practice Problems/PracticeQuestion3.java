class LibraryMember {

    protected String memberId;
    protected int borrowLimit;

    private int totalFine;
    private int[] fineHistory;
    private int fineCount;

    public LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;

        fineHistory = new int[10];
        fineCount = 0;
        totalFine = 0;
    }

    protected void chargeFine(int amount) {

        totalFine += amount;

        if (fineCount < fineHistory.length) {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }

    public int[] getFineHistory() {

        int[] copy = new int[fineCount];

        for (int i = 0; i < fineCount; i++) {
            copy[i] = fineHistory[i];
        }

        return copy;
    }

    public int getTotalFine() {
        return totalFine;
    }
}

class StudentMember extends LibraryMember {

    private String course;

    public StudentMember(String memberId,
                         int borrowLimit,
                         String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class PracticeQuestion3 {

    public static void main(String[] args) {

        StudentMember s =
            new StudentMember("STU5", 3, "CSE");

        s.chargeFine(100);

        System.out.println(
            s.getTotalFine()
        );

        int[] history = s.getFineHistory();

        history[0] = 999;

        System.out.println(
            s.getFineHistory()[0]
        );
    }
}
