import java.util.List;

public class ShippingService {
    public void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Shippable item : items) {
            System.out.printf("%-25s        %.0fg%n", item.getName(), item.getWeight() * 1000);
            totalWeight += item.getWeight();
        }

        System.out.printf("%-25s %.1fkg%n", "Total package weight", totalWeight);
    }
}