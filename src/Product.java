public class Product{
    private String name;
    private double temperature;

    public Product(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }
    public String getName(){
        return name;
    }

    public double getTemperature() {
        return temperature;
    }
}
