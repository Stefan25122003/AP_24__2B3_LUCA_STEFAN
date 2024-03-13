import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Depot> depots = new ArrayList<>();

    public void addDepot(Depot depot) {
        if (!depots.contains(depot)) {
            depots.add(depot);
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        for (Depot depot : depots) {
            allVehicles.addAll(depot.getVehicles());
        }
        return allVehicles;
    }
}
