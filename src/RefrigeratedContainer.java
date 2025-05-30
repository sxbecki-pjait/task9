import java.util.ArrayList;
import java.util.List;

public class RefrigeratedContainer extends Container {
    List<Product> productsAllowed = new ArrayList<>();

    public RefrigeratedContainer(int massOfTheContainer, int height, int tareWeight, int depth, int maxPayloadInKg, String serialNumber) {
        super(massOfTheContainer, height, tareWeight, depth, maxPayloadInKg, serialNumber);
        productsAllowed.add(new Product("Bananas", 13.3));
        productsAllowed.add(new Product("Chocolate", 18));
        productsAllowed.add(new Product("Fish", 2));
        productsAllowed.add(new Product("Meat", -15));
        productsAllowed.add(new Product("Ice Cream", -18));
        productsAllowed.add(new Product("Frozen Pizza", -30));
        productsAllowed.add(new Product("Cheese", 7.2));
        productsAllowed.add(new Product("Sausages", 5));
        productsAllowed.add(new Product("Butter", 20.5));
        productsAllowed.add(new Product("Eggs", 19));
    }
}

class Product{
    String name;
    double temperature;

    public Product(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }
}