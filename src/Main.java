import java.time.LocalDate;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product mobile =new Product(
                "iphone 16",
                400,
                0,
                30,
                LocalDate.of(2025, 7, 9),
                false

        );
        Product tv =new Product(
                "lg tv",
                200,
                0,
                30,
                LocalDate.of(2025, 7, 10),
                false

        );
        Product fridge =new Product(
                "samsong fridge",
                4000,
                400,
                30,
                LocalDate.of(2025, 7, 10),
                true

        );
        Product cheese = new Product("Cheese", 100, 0.2, 5, LocalDate.of(2025, 8, 3), true);


        Customer waled =new Customer("waled",100000,1);
       Cart cart = new Cart(waled);
        cart.add(mobile,5);
       // cart.add(tv,10);
        cart.add(fridge,10);


        CheckoutService checkout =new CheckoutService();
        checkout.checkout(cart,waled);



    }


}