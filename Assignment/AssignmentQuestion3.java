import java.util.*;

abstract class Seat {
    String id;

    Seat(String id) {
        this.id = id;
    }

    abstract double getPrice();
}

class RegularSeat extends Seat {

    RegularSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {

    PremiumSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {

    ReclinerSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 400;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Show {
    String time;
    boolean started = false;
    ArrayList<Seat> bookedSeats = new ArrayList<>();

    Show(String time) {
        this.time = time;
    }

    boolean isAvailable(Seat seat) {
        return !bookedSeats.contains(seat);
    }

    boolean bookSeats(ArrayList<Seat> seats) {

        if (seats.size() > 6) {
            System.out.println("Maximum 6 seats allowed.");
            return false;
        }

        for (Seat seat : seats) {
            if (!isAvailable(seat)) {
                System.out.println("Seat " + seat.id
                        + " is already booked for this show.");
                return false;
            }
        }

        bookedSeats.addAll(seats);
        return true;
    }

    void releaseSeats(ArrayList<Seat> seats) {
        bookedSeats.removeAll(seats);
    }
}

class Booking {
    Customer customer;
    Show show;
    ArrayList<Seat> seats;

    Booking(Customer customer, Show show, ArrayList<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
    }

    double getTotal() {
        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    void cancel() {
        if (show.started) {
            System.out.println("Cannot cancel after show starts.");
            return;
        }

        show.releaseSeats(seats);

        System.out.println(customer.name + "'s booking cancelled.");
        System.out.println("Seats released.");
    }
}

public class AssignmentQuestion3 {

    static Booking book(Customer customer, Show show,
                        ArrayList<Seat> seats) {

        if (!show.bookSeats(seats))
            return null;

        Booking booking =
                new Booking(customer, show, seats);

        System.out.print("Booking confirmed for "
                + customer.name + ": ");

        for (Seat seat : seats)
            System.out.print(seat.id + " ");

        System.out.printf("%nTotal: ₹%.2f%n",
                booking.getTotal());

        return booking;
    }

    public static void main(String[] args) {

        Show show = new Show("7 PM");

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        ArrayList<Seat> ashaSeats = new ArrayList<>();

        ashaSeats.add(new RegularSeat("A1"));
        ashaSeats.add(new RegularSeat("A2"));
        ashaSeats.add(new PremiumSeat("F5"));

        Booking ashaBooking =
                book(asha, show, ashaSeats);

        ArrayList<Seat> raviSeats = new ArrayList<>();
        raviSeats.add(new RegularSeat("A2"));

        book(ravi, show, raviSeats);

        ArrayList<Seat> raviSeats2 = new ArrayList<>();
        raviSeats2.add(new ReclinerSeat("R1"));

        book(ravi, show, raviSeats2);

        ashaBooking.cancel();

        ArrayList<Seat> nehaSeats = new ArrayList<>();
        nehaSeats.add(new RegularSeat("A2"));

        book(neha, show, nehaSeats);
    }
}
