import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CheckoutService {
    public void checkout(Cart cart, Customer customer) {
        if (cart == null || cart.getOrders() == null || cart.getOrders().isEmpty()) {
            throw new RuntimeException("Cart is empty. Please add items before checkout.");
        }

        HashMap<Product, Integer> map = cart.getOrders();
        List<Shippable> itemsToShip = new ArrayList<>();

        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Product product : map.keySet()) {
            int quantity = map.get(product);

            if (ExpiryChecker.isExpired(product)) {
                throw new RuntimeException(product.getName() + " is expired and cannot be purchased.");
            }

            totalWeight += product.getWeight() * quantity;
            System.out.printf("%dx %-20s %.0fg%n", quantity, product.getName(), product.getWeight() * 1000);
            if (product.isShippable()) {
                for (int i = 0; i < quantity; i++) {
                    itemsToShip.add(product);
                }
            }
        }
        System.out.printf("%-20s %.1fkg%n", "Total package weight", totalWeight);

        System.out.println("\n** Checkout receipt **");
        double subtotal = 0;
        double shippingFees = 0;
        for (Product product : map.keySet()) {
            int quantity = map.get(product);
            double originalPrice = product.getPrice();
            double discount = 0;

            if (ExpiryChecker.isNearExpiry(product)) {
                discount = originalPrice * 0.10;
                System.out.printf("%s is near expiry. Applying 10%% discount.\n", product.getName());
            }

            double finalPrice = (originalPrice - discount) * quantity;
            subtotal += finalPrice;

            if (product.isShippable()) {
                shippingFees += quantity * 10;
            }

            System.out.printf("%dx %-20s %.2f EGP\n", quantity, product.getName(), finalPrice);
        }

        double amount = subtotal + shippingFees;
        customer.setBalance(customer.getBalance() - amount);

        System.out.println("----------------------");
        System.out.printf("subtotal       %.2f EGP\n", subtotal);
        System.out.printf("shipping       %.2f EGP\n", shippingFees);
        System.out.printf("amount         %.2f EGP\n", amount);
        System.out.printf("New Balance    %.2f EGP\n", customer.getBalance());
    }
}
