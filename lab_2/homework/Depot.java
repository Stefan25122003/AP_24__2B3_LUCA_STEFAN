import java.util.ArrayList;
import java.util.List;
public class Depot {
    private String name;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Depot(String name) {
        this.name = name;
    }

    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
        }
    }

    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public String toString() {
        return "Depot(" + "Name = '" + name + '\'' + ')';
    }
}
