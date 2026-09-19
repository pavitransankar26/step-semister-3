class GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    void attendSession() {
        sessionsAttended++;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }

    String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    String displayInfo() {
        return "Premium Member | Trainer: " + trainerName
                + " | Sessions: " + sessionsAttended;
    }
}

class EliteMember extends PremiumMember {
    String lockerNumber;

    public EliteMember(String memberId, int monthlyFee,
                       String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    String displayInfo() {
        return "Elite Member | Trainer: " + trainerName
                + " | Locker: " + lockerNumber
                + " | Sessions: " + sessionsAttended;
    }
}

class GroupClassMember extends GymMember {
    String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    String displayInfo() {
        return "Group Class Member | Class: " + className
                + " | Sessions: " + sessionsAttended;
    }
}

public class AssignmentQuestion2 {

    static String classifyGeneration(GymMember member) {

        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }

        return "Base member";
    }

    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;

        for (GymMember member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }

    public static void main(String[] args) {

        GymMember member1 =
            new GymMember("MEM1", 1000);

        PremiumMember member2 =
            new PremiumMember("MEM2", 2000, "Coach Riya");

        EliteMember member3 =
            new EliteMember("MEM3", 3000,
                    "Coach Arjun", "L12");

        GroupClassMember member4 =
            new GroupClassMember("MEM4", 1500, "Zumba");

        System.out.println(member1.displayInfo());
        System.out.println(member2.displayInfo());
        System.out.println(member3.displayInfo());
        System.out.println(member4.displayInfo());

        System.out.println(classifyGeneration(member3));
        System.out.println(classifyGeneration(member4));

        GymMember[] members = {
            member2, member3, member4
        };

        System.out.println(getTotalSessionsAttended(members));
    }
}
