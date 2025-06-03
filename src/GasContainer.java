public class GasContainer extends Container implements iHazardousNotifier{
    private int atmosphere = 1;

    public GasContainer(int height, int tareWeight, int depth, int maxPayloadInKg, ContainerManager cm) {
        super(height, tareWeight, depth, maxPayloadInKg, cm, "CON-G");

    }

    @Override
    public void emptyTheCargo() {
        if(getIsLoaded()){
            System.out.println(getSerialNumber() + ": WARNING: EMPTYING MATERIAL LOSE (5%) IN AMOUNT OF " + (getWeightOfTheCargo()*0.05));
            super.emptyTheCargo();
        }
        else {
            super.emptyTheCargo();
        }
    }


    public boolean loadTheCargo(int newMass, boolean isHazardous) {
        if(super.loadTheCargo(newMass)){
            if(isHazardous){
                hazardousNotify();
            }
            setLoaded(true);
            setMassOfTheCargoAndContainer(newMass);
            System.out.println(getSerialNumber() + ": CARGO LOADED SUCCESSFULLY");
            return true;
        }
        return false;
    }

    @Override
    public void hazardousNotify() {
        System.out.println(getSerialNumber() +  ": HAZARDOUS NOTIFIER: HAZARDOUS MATERIAL IS LOADED!");
    }
}