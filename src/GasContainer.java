public class GasContainer extends Container implements iHazardousNotifier{
    private int atmosphere = 1;

    public GasContainer(int massOfTheContainer, int height, int tareWeight, int depth, int maxPayloadInKg, String serialNumber) {
        super(massOfTheContainer, height, tareWeight, depth, maxPayloadInKg, serialNumber);

    }

    @Override
    public void emptyTheCargo() {
        if(getIsLoaded()){
            setLoaded(false);
            System.out.println("WARNING: EMPTYING MATERIAL LOSE (5%) IN AMOUNT OF " + (getWeightOfTheCargo()*0.05));
        }
    }

    @Override
    public void hazardousNotify() {
        System.out.println("HAZARDOUS NOTIFIER: HAZARDOUS MATERIAL IS LOADED! SERIAL NUMBER: " + getSerialNumber());
    }
}