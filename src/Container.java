public abstract class Container {
    private int massOfTheContainer;
    private int height;
    private int tareWeight;
    private int depth;
    private String serialNumber;
    private int maxPayloadInKg;
    private int weightOfTheCargo = 0;
    private boolean isLoaded = false;

    public Container(int massOfTheContainer, int height, int tareWeight, int depth, int maxPayloadInKg, String serialNumber) {
        this.massOfTheContainer = massOfTheContainer;
        this.height = height;
        this.tareWeight = tareWeight;
        this.depth = depth;
        this.maxPayloadInKg = maxPayloadInKg;
        this.serialNumber = serialNumber;
    }

    public void emptyTheCargo(){
        if(isLoaded){
            isLoaded = false;
            System.out.println("WARNING: EMPTYING THE CARGO: " + serialNumber);
        }
        else{
            System.out.println("WARNING: THE CARGO IS NOT LOADED - CAN NOT PROCEED TO EMPTYING THE CARGO: " + serialNumber);
        }
    }
    public boolean loadTheCargo(int newMass){
        if(maxPayloadInKg < newMass || isLoaded){
            System.out.println("WARNING: THE CARGO IS ALREADY LOADED - CAN NOT PROCEED TO LOADING THE CARGO: " + serialNumber);
            return false;
        }
        return true;
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

    public void setWeightOfTheCargo(int weightOfTheCargo) {
        this.weightOfTheCargo = weightOfTheCargo;
    }
    public int getWeightOfTheCargo() {
        return weightOfTheCargo;
    }
}
