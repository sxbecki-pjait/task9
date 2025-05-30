public class GasContainer extends Container implements iHazardousNotifier{
    public GasContainer(int massOfTheContainer, int height, int tareWeight, int depth, int maxPayloadInKg, String serialNumber) {
        super(massOfTheContainer, height, tareWeight, depth, maxPayloadInKg, serialNumber);

    }

    @Override
    public void hazardousNotify() {
        System.out.println("HAZARDOUS NOTIFIER: HAZARDOUS MATERIAL IS LOADED!");
    }
}