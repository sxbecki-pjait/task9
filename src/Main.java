import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContainerManager cm = new ContainerManager();
        List<Ship> listOfShips = new ArrayList<Ship>();
        RefrigeratedContainer refCon1 = new RefrigeratedContainer(1000, 1000, 1000, 5000, cm);
        GasContainer gasCon1 = new GasContainer(1000,500,1000,5000,cm);
        RefrigeratedContainer refCon2 = new RefrigeratedContainer(1000, 1000, 1000, 5000, cm);
        RefrigeratedContainer refCon3 = new RefrigeratedContainer(1000, 1000, 1000, 5000, cm);
        refCon1.loadTheCargo(2000,new Product("BANANAS", 13.3));
        refCon2.emptyTheCargo();
        gasCon1.emptyTheCargo();
        gasCon1.loadTheCargo(2000,true);
        LiquidContainer liqCon1 = new LiquidContainer(2000,2000,1000,8000,cm);
        liqCon1.emptyTheCargo();
        liqCon1.loadTheCargo(4001,true);
        liqCon1.loadTheCargo(2000,true);
        gasCon1.emptyTheCargo();
        gasCon1.loadTheCargo(1000,true);
        Ship s1 = new Ship(40, 30, 20, "MEDUSA", listOfShips);
        Ship s2 = new Ship(40, 30, 15, "OCTOPUS", listOfShips);
        listOfShips.add(s1);
        listOfShips.add(s2);
        s1.addContainer(gasCon1);
        s1.addContainer(refCon2);
        s1.addContainer(liqCon1);
        s1.displayCurrentContainers();
//        s1.removeContainer(1);
//        s1.displayCurrentContainers();
        s1.replaceContainers(1,refCon3);

        s1.displayCurrentContainers();
        s2.displayCurrentContainers();
        RefrigeratedContainer refCon4 = new RefrigeratedContainer(1000, 1000, 1000, 5000, cm);
        s1.replaceContainers(2,refCon4);
        s1.displayCurrentContainers();
        s1.transferBetweenShips("OCTOPUS", 6);
        s2.displayCurrentContainers();
//        refCon1.displayInformation();
    }
}