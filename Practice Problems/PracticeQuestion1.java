import java.util.*;

abstract class Vehicle {
    String id;
    boolean available = true;

    Vehicle(String id) {
        this.id = id;
    }

    abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String id) {
        super(id);
    }

    double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(String id) {
        super(id);
    }

    double calculateCharge(int days) {
        return days * 80;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }
}

public class PracticeQuestion1 {
    static void rentVehicle(Vehicle vehicle, Customer customer, int days) {
        if (!vehicle.available) {
            System.out.println(vehicle.id + " is currently unavailable.");
            return;
        }

        vehicle.available = false;
        Rental rental = new Rental(vehicle, customer, days);

        System.out.println(vehicle.id + " rented successfully by " + customer.name + ".");
        System.out.println("Rental charge: $" + vehicle.calculateCharge(days));
    }

    static void returnVehicle(Vehicle vehicle, Customer customer) {
        vehicle.available = true;
        System.out.println(vehicle.id + " returned by " + customer.name + ".");
    }

    public static void main(String[] args) {
        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        rentVehicle(sedan, c1, 3);
        rentVehicle(sedan, c2, 2);
        returnVehicle(sedan, c1);
        rentVehicle(suv, c3, 5);
    }
}
