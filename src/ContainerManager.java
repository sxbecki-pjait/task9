import java.util.ArrayList;
import java.util.List;

public class ContainerManager extends Exception {
    private int amountOfGasContainers = 0;
    private int amountOfRefrigeratedContainers = 0;
    private int amountOfLiquidContainers = 0;

    public String assignSerialNumber(String series) {
        if(series.equals("CON-G")) {
            amountOfGasContainers++;
            return "CON-G-" + amountOfGasContainers;
        }
        if(series.equals("CON-R")) {
            amountOfRefrigeratedContainers++;
            return "CON-R-" + amountOfRefrigeratedContainers;
        }
        if(series.equals("CON-L")) {
            amountOfLiquidContainers++;
            return "CON-L-" + amountOfLiquidContainers;
        }
        throw new RuntimeException();
    }

}
