public class LiquidContainer extends Container implements iHazardousNotifier {


    public LiquidContainer(int massOfTheContainer, int height, int tareWeight, int depth, int maxPayloadInKg, ContainerManager cm) {
        super(massOfTheContainer, height, tareWeight, depth, maxPayloadInKg, cm, "CON-L" );

    }

    public boolean loadTheCargo(int newMass, boolean isHazardous) {
        if(super.loadTheCargo(newMass)){
            if(isHazardous && newMass > 0.5*getMaxPayloadInKg()){
                System.out.println(getSerialNumber() + ": WARNING: MAX PAYLOAD FOR HAZARDOUS MATERIAL IS " + Math.round(0.5*getMaxPayloadInKg()) + " => ATTEMPTED QUANTITY: " + newMass + " => LOADING CARGO FAILED");
                return false;
            }
            setLoaded(true);
            System.out.println(getSerialNumber() + ": CARGO LOADED SUCCESSFULLY");
            return true;
        }
        return false;
    }

    @Override
    public void hazardousNotify() {
        System.out.println(getSerialNumber() + ": HAZARDOUS NOTIFIER: HAZARDOUS MATERIAL IS LOADED!");
    }
}
