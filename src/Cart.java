import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {

    private Customer customer;
    private Product product;
    private int numOfItem;
    private HashMap<Product, Integer> orders;
    public Cart(Customer customer) {
        this.orders = new HashMap<>();
        this.customer = customer;
    }

    public HashMap add(Product product ,int quantity)
    {
        product.reduceQuantity(quantity);

        orders.put(product, quantity);
        return orders;
    }

    public HashMap<Product , Integer> getOrders() {
        return orders;
    }



}
