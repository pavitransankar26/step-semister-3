import java.util.*;

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Credit Card payment processing...");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("PayPal payment processing...");
        return false;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    String customer;
    ArrayList<Product> products = new ArrayList<>();
    String status = "Pending";

    Order(String customer) {
        this.customer = customer;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    double getTotal() {
        double total = 0;

        for (Product p : products) {
            total += p.price;
        }

        return total;
    }

    void pay(PaymentMethod method) {
        if (products.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        System.out.println("Payment initiated for Order " + customer);

        if (method.processPayment(getTotal())) {
            status = "Paid";
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class PracticeQuestion5 {
    public static void main(String[] args) {

        Order orderX = new Order("X");

        orderX.addProduct(new Product("Product A", 100));
        orderX.addProduct(new Product("Product B", 50));

        orderX.pay(new CreditCardPayment());

        Order orderY = new Order("Y");
        orderY.pay(new CreditCardPayment());

        Order orderZ = new Order("Z");
        orderZ.addProduct(new Product("Product C", 200));

        orderZ.pay(new PayPalPayment());
    }
}
