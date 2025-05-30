public abstract class Container {
    private int massOfTheContainer;
    private int height;
    private int tareWeight;
    private int depth;
    private String serialNumber;
    private int maxPayloadInKg;
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

    }
    public boolean loadingTheCargo(int newMass){
        if(maxPayloadInKg < newMass || isLoaded){
            return false;
        }
        return true;
    }

}
