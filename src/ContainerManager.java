import java.util.ArrayList;
import java.util.List;

public class ContainerManager extends Exception {
    private int amountOfContainers = 0;

    public String assignSerialNumber(String series) {
        amountOfContainers++;
        return switch (series) {
            case "CON-G" -> "CON-G-" + amountOfContainers;
            case "CON-R" -> "CON-R-" + amountOfContainers;
            case "CON-L" -> "CON-L-" + amountOfContainers;
            default -> throw new RuntimeException();
        };
    }

}
