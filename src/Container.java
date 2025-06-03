public abstract class Container {
    private int massOfTheContainer;
    private int height;
    private int tareWeight;
    private int depth;
    private String serialNumber;
    private int maxPayloadInKg;
    private int weightOfTheCargo = 0;
    private boolean isLoaded = false;
    private ContainerManager cm;

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
        if(isLoaded){
            isLoaded = false;
            System.out.println(serialNumber + ": WARNING: EMPTYING THE CARGO");
            setMassOfTheCargoAndContainer(0);
        }
        else{
            System.out.println(serialNumber + ": WARNING: THE CARGO IS NOT LOADED - CAN NOT PROCEED TO EMPTYING THE CARGO");
        }
    }
    public boolean loadTheCargo(int newMass){
        if(isLoaded){
            System.out.println(serialNumber + ": WARNING: THE CARGO IS ALREADY LOADED - CAN NOT PROCEED TO LOADING THE CARGO");
            return false;
        }
        else if(maxPayloadInKg < newMass){
            System.out.println(serialNumber + ": WARNING: THE CARGO IS ALREADY LOADED - CAN NOT PROCEED TO LOADING THE CARGO");
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
}
