class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {

        this.memberId = memberId;
        this.bookIds = new String[bookIds.length];

        for (int i = 0; i < bookIds.length; i++) {
            this.bookIds[i] = bookIds[i];
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {

        String[] copy = new String[bookIds.length];

        for (int i = 0; i < bookIds.length; i++) {
            copy[i] = bookIds[i];
        }

        return copy;
    }

    public LoanReceipt withCorrectedBookId(
            int index, String newId) {

        String[] correctedIds = getBookIds();

        if (index >= 0 && index < correctedIds.length) {
            correctedIds[index] = newId;
        }

        return new LoanReceipt(memberId, correctedIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {

        super(memberId, bookIds);

        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

class CirculationLedger {

    static String branchCode;

    static {
        branchCode = "PTL-001";
    }

    static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (int i = 0; i < receipts.length; i++) {

            if (receipts[i] == null) {

                nullSkipped++;

            } else if (receipts[i]
                    instanceof ReferenceOnlyLoanReceipt) {

                processed++;
                referenceOnly++;

            } else {

                processed++;
                regular++;
            }
        }

        return processed + " processed | " +
                nullSkipped + " null skipped | " +
                referenceOnly + " reference-only | " +
                regular + " regular";
    }
}

public class AssignmentQuestion5 {

    public static void main(String[] args) {

        LoanReceipt r = new LoanReceipt(
                "LIB-8841",
                new String[]{"BK-100", "BK-101"}
        );

        String[] ids = r.getBookIds();

        ids[0] = "HACKED";

        System.out.println(
                r.getBookIds()[0]
        );

        LoanReceipt corrected =
                r.withCorrectedBookId(1, "BK-102");

        String[] original = r.getBookIds();
        String[] newReceipt = corrected.getBookIds();

        System.out.println(
                original[0] + ", " + original[1]
        );

        System.out.println(
                newReceipt[0] + ", " + newReceipt[1]
        );

        LoanReceipt[] receipts = {

                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[]{"BK-200"},
                        "Reading Room 3"
                ),

                null,

                new LoanReceipt(
                        "LIB-002",
                        new String[]{"BK-201"}
                )
        };

        System.out.println(
                CirculationLedger
                        .processNightlyCirculation(receipts)
        );
    }
}
