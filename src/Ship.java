import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ship {
    private List<Container> containerList = new ArrayList<>();
    private int maxSpeed;
    private int maxNumberOfContainers;
    private int maxWeightOfALlContainers;
    private String shipName;
    private int currentWeightOfALlContainers;
    private int currentNumberOfContainers;

    public Ship(int maxSpeed, int maxNumberOfContainers, int maxWeightOfALlContainers, String shipName) {
        this.maxSpeed = maxSpeed;
        this.maxNumberOfContainers = maxNumberOfContainers;
        this.maxWeightOfALlContainers = maxWeightOfALlContainers;
        this.shipName = shipName;
    }

    public boolean addContainer(Container container) {
        if(containerList.size() >= maxNumberOfContainers) {
            System.out.println(shipName + " SHIP: WARNING: CANNOT ADD MORE CONTAINERS: THE MAXIMUM NUMBER OF CONTAINERS HAS BEEN REACHED");
            return false;
        }
        if(currentWeightOfALlContainers + container.getMassOfTheContainer() > maxWeightOfALlContainers * 1000) {
            System.out.println(shipName + ": WARNING: CONTAINER " + container.getSerialNumber() + " CANNOT BE LOADED: SHIP REACHED IT'S MAX CARRY WEIGHT");
            return false;
        }
        containerList.add(container);
        currentNumberOfContainers++;
        currentWeightOfALlContainers += container.getMassOfTheContainer();
        System.out.println(shipName + ": CONTAINER " + container.getSerialNumber() + ", WEIGHT :" + container.getMassOfTheContainer() +" ADDED");
        return true;
    }

    public boolean addContainer(List<Container> newContainerList) {
        int totalMassOfNewContainers = 0;
        int totalAmountOfNewContainers = 0;
        if(containerList.size() >= maxNumberOfContainers) {
            System.out.println(shipName + " SHIP: WARNING: CANNOT ADD MORE CONTAINERS: THE MAXIMUM NUMBER OF CONTAINERS HAS BEEN REACHED");
            return false;
        }
        for(int i = 0; i < newContainerList.size(); i++) {
            totalMassOfNewContainers += newContainerList.get(i).getMassOfTheContainer();
            totalAmountOfNewContainers ++;
        }
        if(totalAmountOfNewContainers + currentNumberOfContainers > maxNumberOfContainers) {
            System.out.println(shipName + ": WARNING: CONTAINERS CANNOT BE LOADED: SHIP REACHED IT'S MAX AMOUNT OF CONTAINERS");
            return false;
        }
        if(currentWeightOfALlContainers + totalMassOfNewContainers >= maxWeightOfALlContainers * 1000) {
            System.out.println(shipName + ": WARNING: CONTAINERS CANNOT BE LOADED: SHIP REACHED IT'S MAX CARRY WEIGHT");
            return false;
        }
        for(Container c : newContainerList) {
            containerList.add(c);
            currentNumberOfContainers++;
            currentWeightOfALlContainers += c.getMassOfTheContainer();
        }
        return true;
    }

    public int getCurrentNumberOfContainers() {
        return currentNumberOfContainers;
    }

    public int getCurrentWeightOfALlContainers() {
        return currentWeightOfALlContainers;
    }

    public void displayCurrentContainers(){
        if(currentNumberOfContainers == 0){
            System.out.println(shipName + " SHIP: NO CONTAINERS FOUND");
        }
        System.out.println("\nTHE LIST OF CONTAINERS ON SHIP");
        for(Container c : containerList) {
            System.out.print(c.getSerialNumber());
            if(c instanceof RefrigeratedContainer){
                System.out.println(" PRODUCT LOADED: " + ((RefrigeratedContainer) c).getCurrentLoadedProduct());
            }
            else if(c instanceof LiquidContainer || c instanceof GasContainer){
                System.out.println(" IS CARGO HAZARDOUS: " + c.getIsHazardous());
            }
            else{
                System.out.println();
            }
        }
    }
}
