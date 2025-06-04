import java.util.ArrayList;
import java.util.List;

public class RefrigeratedContainer extends Container {
    List<Product> productsAllowed = new ArrayList<>();
    private String currentLoadedProduct= "N/A";
    private double currentTemperature = 20;


    public RefrigeratedContainer(int height, int tareWeight, int depth, int maxPayloadInKg, ContainerManager containerManager) {
        super(height, tareWeight, depth, maxPayloadInKg, containerManager, "CON-R");
        productsAllowed.add(new Product("bananas", 13.3));
        productsAllowed.add(new Product("chocolate", 18));
        productsAllowed.add(new Product("fish", 2));
        productsAllowed.add(new Product("meat", -15));
        productsAllowed.add(new Product("ice cream", -18));
        productsAllowed.add(new Product("frozen pizza", -30));
        productsAllowed.add(new Product("cheese", 7.2));
        productsAllowed.add(new Product("sausages", 5));
        productsAllowed.add(new Product("butter", 20.5));
        productsAllowed.add(new Product("eggs", 19));
    }

    public void emptyTheCargo(){
        super.emptyTheCargo();
        currentLoadedProduct = "N/A";
        currentTemperature = 20;
    }

    public boolean loadTheCargo(int newMass, Product newProduct){
        boolean isProductOnTheList = false;
        for(Product p : productsAllowed){
            if(newProduct.getName().equals(p.getName().toUpperCase())){
                isProductOnTheList = true;
                break;
            }
        }
        if(!isProductOnTheList){
            System.out.println(getSerialNumber() + ": WARNING: THE PRODUCT IS NOT ON THE LIST - CAN NOT PROCEED TO LOADING THE CARGO");
            return false;
        }
        if(getIsLoaded()){
            System.out.println(getSerialNumber() + ": WARNING: THE CARGO IS ALREADY LOADED - CAN NOT PROCEED TO LOADING THE CARGO" );
            return false;
        }

        else {
            currentLoadedProduct = newProduct.getName();
            currentTemperature = newProduct.getTemperature();
            setLoaded(true);
            setMassOfTheCargoAndContainer(newMass);
            System.out.println(getSerialNumber() + ": WARNING: THE CARGO WAS LOADED SUCCESSFULLY WITH " +newProduct.getName().toUpperCase());
            return true;
        }
    }

    public String getCurrentLoadedProduct() {
        return currentLoadedProduct;
    }
}
