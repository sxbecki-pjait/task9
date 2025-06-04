import javax.sound.midi.SysexMessage;

public abstract class Container {
    private int massOfTheContainer;
    private final int height;
    private final int tareWeight;
    private final int depth;
    private final String serialNumber;
    private final int maxPayloadInKg;
    private int weightOfTheCargo = 0;
    private boolean isLoaded = false;
    private final ContainerManager cm;
    private boolean isHazardous = false;
    private boolean isOnBoard = false;

    public Container(int height, int tareWeight, int depth, int maxPayloadInKg, ContainerManager containerManager, String series) {
        this.massOfTheContainer = tareWeight;
        this.height = height;
        this.tareWeight = tareWeight;
        this.depth = depth;
        this.maxPayloadInKg = maxPayloadInKg;
        this.cm = containerManager;
        this.serialNumber = cm.assignSerialNumber(series);
    }

    public void emptyTheCargo(){
        String cannotProceed = ": WARNING: CANNOT PROCEED TO EMPTYING THE CARGO: ";
        if(isOnBoard){
            System.out.println(serialNumber + cannotProceed + "CARGO IS ON BOARD");
            if(!isLoaded){
                System.out.println(serialNumber + cannotProceed + "CARGO IS ON BOARD AND IS ALREADY EMPTY");
            }
        }
        else if(isLoaded){
            isLoaded = false;
            System.out.println(serialNumber + ": WARNING: EMPTYING THE CARGO");
            setIsHazardous(false);
            setMassOfTheCargoAndContainer(0);
        }
        else{
            System.out.println(serialNumber + cannotProceed + "CARGO IS NOT LOADED");
        }
    }

    public boolean loadTheCargo(int newMass){
        String cannotProceed = ": WARNING: CANNOT PROCEED TO LOADING THE CARGO: ";
        if(isOnBoard){
            System.out.println(serialNumber + cannotProceed + "CARGO IS ON BOARD");
            return false;
        }
        if(isLoaded){
            System.out.println(serialNumber + cannotProceed + "THE CARGO IS ALREADY LOADED");
            return false;
        }
        else if(maxPayloadInKg < newMass){
            System.out.println(serialNumber + cannotProceed + "THE CARGO IS ALREADY FULLY LOADED");
            return false;
        }
        else{
            return true;
        }
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }
    public boolean getIsLoaded(){
        return isLoaded;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getMaxPayloadInKg(){
        return maxPayloadInKg;
    }

    public int getMassOfTheContainer() {
        return massOfTheContainer;
    }

    public int getTareWeight() {
        return tareWeight;
    }

    public int getWeightOfTheCargo() {
        return weightOfTheCargo;
    }

    public void setMassOfTheCargoAndContainer(int massOfTheCargo) {
        this.weightOfTheCargo = massOfTheCargo;
        this.massOfTheContainer = tareWeight + massOfTheCargo;
    }

    public boolean getIsHazardous() {
        return isHazardous;
    }

    public void setIsHazardous(boolean isHazardous) {
        this.isHazardous = isHazardous;
    }

    public void displayInformation(){
        System.out.println("\nDISPLAYING INFORMATION ABOUT CONTAINER " + serialNumber);
        String space = "    - ";
        System.out.println(space + "MAX PAYLOAD IN KG: " + maxPayloadInKg);
        System.out.println(space + "WEIGHT OF THE CARGO: " + weightOfTheCargo);
        System.out.println(space + "TARE WEIGHT OF THE CARGO: " + tareWeight);
        System.out.println(space + "TOTAL MASS OF THE CONTAINER: " + massOfTheContainer);
        System.out.println(space + "DEPTH OF THE CARGO: " + depth);
        System.out.println(space + "HEIGHT OF THE CARGO: " + height);
        System.out.println(space + "MAX PAYLOAD IN KG: " + maxPayloadInKg);
        System.out.println(space + "IS LOADED: " + (String.valueOf(isLoaded)).toUpperCase());
        if(isLoaded){
            System.out.println(space + "IS CARGO HAZARDOUS: " + (String.valueOf(isHazardous)).toUpperCase());
        }
    }

    public void setOnBoard(boolean onBoard) {
        isOnBoard = onBoard;
    }
    public boolean getIsOnBoard() {
        return isOnBoard;
    }
}
