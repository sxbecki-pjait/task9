import java.util.ArrayList;
import java.util.List;

public class ContainerManager extends Exception {
    private int amountOfContainers = 0;

    public String assignSerialNumber(String series) {
        amountOfContainers++;
        if(series.equals("CON-G")) {
            return "CON-G-" + amountOfContainers;
        }
        if(series.equals("CON-R")) {
            return "CON-R-" + amountOfContainers;
        }
        if(series.equals("CON-L")) {
            return "CON-L-" + amountOfContainers;
        }
        throw new RuntimeException();
    }

}
