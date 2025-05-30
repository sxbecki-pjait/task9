import java.util.ArrayList;
import java.util.List;

public class RefrigeratedContainer extends Container {
    List<Product> productsAllowed = new ArrayList<>();
    private String currentLoadedProduct= "N/A";
    private double currentTemperature = 20;


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

    public void emptyTheCargo(){
        super.emptyTheCargo();
        currentLoadedProduct = "N/A";
        currentTemperature = 20;
    }

    public boolean loadTheCargo(int newMass, Product newProduct){
        boolean isProductOnTheList = false;
        for(Product p : productsAllowed){
            if(p.getName() == newProduct.getName()){
                isProductOnTheList = true;
                break;
            }
        }
        if(!isProductOnTheList){
            System.out.println("WARNING: THE PRODUCT IS NOT ON THE LIST - CAN NOT PROCEED TO LOADING THE CARGO: " + getSerialNumber());
            return false;
        }
        if(getIsLoaded()){
            System.out.println("WARNING: THE CARGO IS ALREADY LOADED - CAN NOT PROCEED TO LOADING THE CARGO: " + getSerialNumber());
            return false;
        }

        else {
            currentLoadedProduct = newProduct.getName();
            currentTemperature = newProduct.getTemperature();
            setLoaded(true);
            return true;
        }
    }
}
