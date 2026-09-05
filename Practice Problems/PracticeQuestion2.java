class Employee {
    String id;
    double salary;

    Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    void printSalary() {
        System.out.println(id + " | Final Salary: Rs " + salary);
    }
}

public class PracticeQuestion2 {
    public static void main(String[] args) {

        double[] salaries = {40000, 55000, 62000, 48000};

        Employee[] employees = {
            new Employee("E-101", salaries[0]),
            new Employee("E-102", salaries[1]),
            new Employee("E-103", salaries[2]),
            new Employee("E-104", salaries[3])
        };

        for (Employee employee : employees) {
            employee.raiseSalary(5000);
            employee.printSalary();
        }
    }
}
