import java.util.List;
public class Main {
    public enum ClientType {REGULAR, PREMIUM}

    public static void main(String[] args) {

        Client regularClient = new Client("Client 1", 9, 17, ClientType.REGULAR);
        Client premiumClient = new Client("Client 2", 10, 16, ClientType.PREMIUM);


        Depot depot1 = new Depot("Depot 1");
        Truck truck1 = new Truck("Truck 1", depot1, 100);
        Drone drone1 = new Drone("Drone 1", depot1, 120);


        depot1.addVehicle(truck1);
        depot1.addVehicle(drone1);


        Problem problem = new Problem();
        problem.addDepot(depot1);


        System.out.println("All Vehicles in the Problem:");
        List<Vehicle> allVehicles = problem.getAllVehicles();
        for (Vehicle vehicle : allVehicles) {
            System.out.println(vehicle);
        }
    }
}
