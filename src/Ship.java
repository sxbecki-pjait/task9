import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ship {
    private final List<Container> containerList = new ArrayList<>();
    private List<Ship> listOfShips = new ArrayList<>();
    private final int maxSpeed;
    private final int maxNumberOfContainers;
    private final int maxWeightOfALlContainers;
    private final String shipName;
    private int currentWeightOfALlContainers;
    private int currentNumberOfContainers;
    private final String upperDividerText = "\n==== SHIP ALERT ==============================";
    private final String lowerDividerText = "";

    public Ship(int maxSpeed, int maxNumberOfContainers, int maxWeightOfALlContainers, String shipName, List<Ship> listOfShips) {
        this.maxSpeed = maxSpeed;
        this.maxNumberOfContainers = maxNumberOfContainers;
        this.maxWeightOfALlContainers = maxWeightOfALlContainers;
        this.shipName = shipName;
        this.listOfShips = listOfShips;
    }

    public boolean addContainer(Container container) {
        System.out.println(upperDividerText);
        if(containerList.size() >= maxNumberOfContainers) {
            System.out.println(shipName + " SHIP: WARNING: CANNOT ADD MORE CONTAINERS: THE MAXIMUM NUMBER OF CONTAINERS HAS BEEN REACHED");
            return false;
        }
        if(currentWeightOfALlContainers + container.getMassOfTheContainer() > maxWeightOfALlContainers * 1000) {
            System.out.println(shipName + " SHIP: WARNING: CONTAINER " + container.getSerialNumber() + " CANNOT BE LOADED: SHIP REACHED IT'S MAX CARRY WEIGHT");
            return false;
        }
        containerList.add(container);
        currentNumberOfContainers++;
        currentWeightOfALlContainers += container.getMassOfTheContainer();
        System.out.println(shipName + " SHIP: CONTAINER " + container.getSerialNumber() + ", WEIGHT :" + container.getMassOfTheContainer() +" ADDED");
        System.out.println(lowerDividerText);
        return true;
    }

    public boolean addContainer(Container container, boolean displayInfo) {
        if(displayInfo) {
            System.out.println(upperDividerText);
        }
        if(containerList.size() >= maxNumberOfContainers) {
            System.out.println(shipName + " SHIP: WARNING: CANNOT ADD MORE CONTAINERS: THE MAXIMUM NUMBER OF CONTAINERS HAS BEEN REACHED");
            if(displayInfo) {
                System.out.println(lowerDividerText);
            }
            return false;
        }
        if(currentWeightOfALlContainers + container.getMassOfTheContainer() > maxWeightOfALlContainers * 1000) {
            System.out.println(shipName + " SHIP: WARNING: CONTAINER " + container.getSerialNumber() + " CANNOT BE LOADED: SHIP REACHED IT'S MAX CARRY WEIGHT");
            if(displayInfo) {
                System.out.println(lowerDividerText);
            }
            return false;
        }
        containerList.add(container);
        currentNumberOfContainers++;
        currentWeightOfALlContainers += container.getMassOfTheContainer();
        System.out.println(shipName + " SHIP: CONTAINER " + container.getSerialNumber() + ", WEIGHT :" + container.getMassOfTheContainer() +" ADDED");
        if(displayInfo) {
            System.out.println(lowerDividerText);
        }
        return true;
    }

    public boolean addContainer(List<Container> newContainerList) {
        int totalMassOfNewContainers = 0;
        int totalAmountOfNewContainers = 0;
        if(containerList.size() >= maxNumberOfContainers) {
            System.out.println(shipName + " SHIP: WARNING: CANNOT ADD MORE CONTAINERS: THE MAXIMUM NUMBER OF CONTAINERS HAS BEEN REACHED");
            return false;
        }
        for (Container container : newContainerList) {
            totalMassOfNewContainers += container.getMassOfTheContainer();
            totalAmountOfNewContainers++;
        }
        if(totalAmountOfNewContainers + currentNumberOfContainers > maxNumberOfContainers) {
            System.out.println(shipName + " SHIP: WARNING: CONTAINERS CANNOT BE LOADED: SHIP REACHED IT'S MAX AMOUNT OF CONTAINERS");
            return false;
        }
        if(currentWeightOfALlContainers + totalMassOfNewContainers >= maxWeightOfALlContainers * 1000) {
            System.out.println(shipName + " SHIP: WARNING: CONTAINERS CANNOT BE LOADED: SHIP REACHED IT'S MAX CARRY WEIGHT");
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
        System.out.println(upperDividerText);
        System.out.println("THE LIST OF CONTAINERS ON " + shipName + " SHIP");
        if(currentNumberOfContainers == 0){
            System.out.println(shipName + " SHIP: NO CONTAINERS FOUND");
        }
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
        System.out.println(lowerDividerText);
    }

    public boolean removeContainer(int serialNumber) {
        System.out.println(upperDividerText);
        for(Container c : containerList) {
            if(c.getSerialNumber().endsWith(String.valueOf(serialNumber))) {
                containerList.remove(c);
                currentNumberOfContainers--;
                currentWeightOfALlContainers -= c.getMassOfTheContainer();
                System.out.println(shipName + " SHIP: CONTAINER " + c.getSerialNumber() + " REMOVED");
                c.setOnBoard(false);
                return true;
            }
        }
        System.out.println(lowerDividerText);
        return false;
    }

    public boolean removeContainer(int serialNumber, boolean displayInfo) {
        if(displayInfo) {
            System.out.println(upperDividerText);
        }
        for(Container c : containerList) {
            if(c.getSerialNumber().endsWith(String.valueOf(serialNumber))) {
                containerList.remove(c);
                currentNumberOfContainers--;
                currentWeightOfALlContainers -= c.getMassOfTheContainer();
                System.out.println(shipName + " SHIP: CONTAINER " + c.getSerialNumber() + " REMOVED");
                c.setOnBoard(false);
                if(displayInfo) {
                    System.out.println(lowerDividerText);
                }
                return true;
            }
        }
        if(displayInfo) {
            System.out.println(lowerDividerText);
        }
        return false;
    }

    public boolean replaceContainers(int toBeRemoved, Container newContainer){
        System.out.println(upperDividerText);
        System.out.println("REPLACE CONTAINERS OPERATION INITIATED");
        Container toBeReplaced = null;
        for(Container c : containerList) {
            if(c.getSerialNumber().endsWith(String.valueOf(toBeRemoved))) {
                toBeReplaced = c;
            }
            if(c.getSerialNumber().endsWith(String.valueOf(newContainer.getSerialNumber()))) {
                System.out.println(shipName + " SHIP: WARNING: CONTAINER " + c.getSerialNumber() + " IS ALREADY ONBOARD: CANNOT PROCEED TO REPLACING");
                System.out.println(lowerDividerText);
                return false;
            }
        }
        if(toBeReplaced == null) {
            System.out.println(shipName + " SHIP: NO CONTAINERS FOUND");
            System.out.println(lowerDividerText);
            return false;
        }
        if(currentWeightOfALlContainers + newContainer.getMassOfTheContainer() - toBeReplaced.getMassOfTheContainer() > maxWeightOfALlContainers * 1000) {
            System.out.println(shipName + " SHIP WARNING: CONTAINERS " + toBeReplaced.getSerialNumber() + " AND " + newContainer.getSerialNumber() + " CANNOT BE REPLACED: TOO MUCH WEIGHT");
            System.out.println(lowerDividerText);
            return false;
        }
        currentWeightOfALlContainers += newContainer.getMassOfTheContainer() - toBeReplaced.getMassOfTheContainer();
        System.out.println(shipName + " SHIP WARNING: CONTAINERS " + toBeReplaced.getSerialNumber() + " AND " + newContainer.getSerialNumber() + " ARE REPLACED SUCCESSFULLY");
        containerList.remove(toBeReplaced);
        containerList.add(newContainer);
        System.out.println(lowerDividerText);
        return true;
    }

    public void displayListOfShips() {
        System.out.println(upperDividerText);
        System.out.println("THE LIST OF SHIPS");
        for(Ship s : listOfShips) {
            System.out.println(s.shipName);
        }
        System.out.println(lowerDividerText);
    }

    public boolean transferBetweenShips(String toShipName, int containerNumber) {
        System.out.println(upperDividerText);
        System.out.println("NEW CONTAINERS TRANSFER INITIATED: " + shipName + " SHIP => " + toShipName + " SHIP");
        Ship toShip = null;
        Container container = null;
        for(Ship s : listOfShips) {
            if(s.getShipName().equals(toShipName)) {
                toShip = s;
            }
        }
        for(Container c : containerList) {
            if(c.getSerialNumber().endsWith(String.valueOf(containerNumber))) {
                container = c;
            }
        }
        if(container == null) {
            System.out.println(shipName + " SHIP: NO CONTAINERS TO BE TRANSFERRED FROM FOUND");
            System.out.println(lowerDividerText);
            return false;
        }
        if(toShip == null) {
            System.out.println(shipName + " SHIP: NO SHIP FOUND WITH NAME " + toShipName );
            System.out.println(lowerDividerText);
            return false;
        }
        if(toShip.addContainer(container, false)) {
            removeContainer(containerNumber, false);
            System.out.println(shipName + " SHIP: SUCCESSFULLY TRANSFERRED");
            System.out.println(lowerDividerText);
            return true;
        }
        else{
            return false;
        }
    }

    public String getShipName() {
        return shipName;
    }
}
