import java.time.LocalDate;

public class ExpiryChecker {
    public static boolean isExpired(Product product) {
        return LocalDate.now().isAfter(product.getExpiryDate());
    }

    public static boolean isNearExpiry(Product product) {
        return LocalDate.now().plusDays(7).isAfter(product.getExpiryDate());
    }
}
