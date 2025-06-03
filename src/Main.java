public class Main {
    public static void main(String[] args) {
        ContainerManager cm = new ContainerManager();
        RefrigeratedContainer refCon1 = new RefrigeratedContainer(100, 100, 1000, 100, 5000, cm);
        RefrigeratedContainer refCon2 = new RefrigeratedContainer(100, 100, 1000, 100, 5000, cm);
        GasContainer gasCon1 = new GasContainer(100,100,1000,50,300,cm);
        refCon1.loadTheCargo(1000,new Product("Bananas", 13.3));
        refCon2.emptyTheCargo();
        gasCon1.emptyTheCargo();
        gasCon1.loadTheCargo(100,true);
        LiquidContainer liqCon1 = new LiquidContainer(100,100,1000,50,300,cm);
        liqCon1.emptyTheCargo();
        liqCon1.loadTheCargo(200,true);
        liqCon1.loadTheCargo(100,true);
    }
}