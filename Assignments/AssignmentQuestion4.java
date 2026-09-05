class LibraryMember {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMember() {
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        if (membershipId == null) {
            membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {

        if (answer != null) {

            // Simple deterministic one-way transformation
            securityAnswer =
                    Integer.toString(answer.hashCode());
        }
    }
}

public class AssignmentQuestion4 {

    public static void main(String[] args) {

        LibraryMember m = new LibraryMember();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(
                "Membership ID: " + m.getMembershipId()
        );

        System.out.println(
                "Name: " + m.getName()
        );

        System.out.println(
                "Premium Member: " +
                        m.isPremiumMember()
        );

        m.setMembershipId("FAKE-0000");

        System.out.println(
                "Membership ID after second attempt: " +
                        m.getMembershipId()
        );

        m.setSecurityAnswer("BlueMountain");
    }
}
