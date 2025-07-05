import java.time.LocalDate;

public class Product implements Shippable {
    private String name;
    private double price;
    private double weight;
    private int quantity;
    private LocalDate expiryDate;
    private boolean shippable;

    public Product(String name, double price, double weight, int quantity,  LocalDate expiryDate, boolean shippable) {

        if(name ==null)
        {
            throw new IllegalArgumentException("Name of product can't be null");
        }
        this.name = name;

        if(price == 0 || price < 0)
        {
            throw new IllegalArgumentException("price should be positive number");
        }

        this.price = price;

        if (shippable && weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive for shippable products");
        }
        if (!shippable && weight != 0) {
            throw new IllegalArgumentException("Weight must be 0 for non-shippable products");
        }
        this.weight = weight;
        this.shippable = shippable;

        if(quantity==0 || quantity< 0)
        {
            throw new IllegalArgumentException("weight should be positive");
        }
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShippable() {
        return shippable;
    }

    public void setShippable(boolean shippable) {
        this.shippable = shippable;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if((this.quantity-quantity) <0)
        {
            throw new IllegalArgumentException("avalible quantity of product is "+getQuantity());
        }
        this.quantity = quantity;

    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void reduceQuantity(int quantityToReduce) {
        if (quantityToReduce < 0) {
            throw new IllegalArgumentException(" quantity should be positive number");
        }

        if (this.quantity < quantityToReduce) {
            throw new IllegalStateException("avalible quanitiy is : " + this.quantity);
        }

        this.quantity -= quantityToReduce;
    }
}
