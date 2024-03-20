import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create attractions
        Church church = new Church("Biserica Sf. Nicolae");
        church.setVisitingHours(LocalDate.of(2024, 3, 19), LocalTime.of(9, 0), LocalTime.of(18, 0));

        Concert concert = new Concert("Subcarpati", 100.00);
        concert.setVisitingHours(LocalDate.of(2024, 3, 20), LocalTime.of(20, 0), LocalTime.of(23, 0));

        Statue statue = new Statue("Hydra");
        statue.setVisitingHours(LocalDate.of(2024, 3, 19), LocalTime.of(10, 0), LocalTime.of(17, 0));


        Trip trip = new Trip("Iasi", Arrays.asList(church, concert, statue));


        System.out.println(trip);


        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addAttraction(church, LocalDate.of(2024, 3, 19));
        travelPlan.addAttraction(concert, LocalDate.of(2024, 3, 20));
        travelPlan.addAttraction(statue, LocalDate.of(2024, 3, 19));


        System.out.println("\nTravel Plan:");
        travelPlan.printTravelPlan();
    }
}
