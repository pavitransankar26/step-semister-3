interface MembershipPlan {
    double calculateFee();
    String getName();
}

class MonthlyPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000;
    }

    public String getName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    public String getName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    public String getName() {
        return "Annual";
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

class Membership {
    Member member;
    MembershipPlan plan;
    private String status = "Active";

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;

        System.out.println(plan.getName()
                + " membership created for "
                + member.name + ".");

        System.out.printf("Fee: ₹%.2f%n", plan.calculateFee());
        System.out.println("Status: " + status);
    }

    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.name
                    + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: "
                    + member.name
                    + "'s membership is " + status + ".");
        }
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";

            System.out.println(member.name
                    + "'s membership frozen.");
            System.out.println("Status: " + status);
        } else {
            System.out.println("Cannot freeze an "
                    + status + " membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";

            System.out.println(member.name
                    + "'s membership unfrozen.");
        } else {
            System.out.println("Cannot unfreeze an "
                    + status + " membership.");
        }
    }

    void expire() {
        status = "Expired";

        System.out.println(member.name
                + "'s membership expired.");
        System.out.println("Status: " + status);
    }
}

public class AssignmentQuestion4 {
    public static void main(String[] args) {

        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership ashaMembership =
                new Membership(asha, new QuarterlyPlan());

        Membership raviMembership =
                new Membership(ravi, new MonthlyPlan());

        ashaMembership.checkIn();

        ashaMembership.freeze();

        ashaMembership.checkIn();

        raviMembership.expire();

        raviMembership.freeze();
    }
}
