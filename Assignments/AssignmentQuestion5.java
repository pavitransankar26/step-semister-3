class EmployeeDetails {
    String empName;
    double salary;

    static String companyName =
            "Bright Horizon Technologies";

    static int employeeCount = 0;

    EmployeeDetails(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: "
                + employeeCount);
    }
}

public class AssignmentQuestion5 {
    public static void main(String[] args) {

        EmployeeDetails emp1 =
                new EmployeeDetails("Arun", 50000);

        EmployeeDetails emp2 =
                new EmployeeDetails("Divya", 60000);

        EmployeeDetails emp3 =
                new EmployeeDetails("Kumar", 55000);

        EmployeeDetails.printCompanyInfo();
    }
}
