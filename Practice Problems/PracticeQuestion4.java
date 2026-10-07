abstract class Room {
    String roomNumber;
    boolean available = true;

    Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    abstract double calculatePrice(int days);
}

class StandardRoom extends Room {
    StandardRoom(String roomNumber) {
        super(roomNumber);
    }

    double calculatePrice(int days) {
        return days * 100;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(String roomNumber) {
        super(roomNumber);
    }

    double calculatePrice(int days) {
        return days * 150;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Customer customer;
    Room room;
    int days;

    Reservation(Customer customer, Room room, int days) {
        this.customer = customer;
        this.room = room;
        this.days = days;
    }
}

public class PracticeQuestion4 {

    static void checkAvailability(Room room) {
        if (room.available)
            System.out.println(room.roomNumber + " is available.");
        else
            System.out.println(room.roomNumber + " is not available.");
    }

    static void reserveRoom(Customer customer, Room room, int days) {
        if (!room.available) {
            System.out.println(room.roomNumber + " is not available.");
            return;
        }

        room.available = false;
        new Reservation(customer, room, days);

        System.out.println("Reservation confirmed for "
                + customer.name + ", " + room.roomNumber);
        System.out.println("Price: $" + room.calculatePrice(days));
    }

    static void cancelReservation(Customer customer, Room room) {
        room.available = true;
        System.out.println("Reservation for " + customer.name
                + ", " + room.roomNumber + " cancelled successfully.");
    }

    public static void main(String[] args) {

        Room standard = new StandardRoom("Standard Room 101");
        Room deluxe = new DeluxeRoom("Deluxe Room 201");

        Customer customerA = new Customer("Customer A");
        Customer customerB = new Customer("Customer B");
        Customer customerC = new Customer("Customer C");

        checkAvailability(standard);

        reserveRoom(customerA, standard, 4);

        reserveRoom(customerB, standard, 4);

        cancelReservation(customerA, standard);

        reserveRoom(customerC, deluxe, 2);
    }
}
