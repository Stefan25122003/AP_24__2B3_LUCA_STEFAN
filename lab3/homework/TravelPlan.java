import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalTime;

public class TravelPlan {
    private Map<Attractions, LocalDate> plan;

    public TravelPlan() {
        plan = new HashMap<>();
    }

    public void addAttraction(Attractions attraction, LocalDate date) {
        plan.put(attraction, date);
    }

    public void printTravelPlan() {
        for (Map.Entry<Attractions, LocalDate> entry : plan.entrySet()) {
            System.out.println("On " + entry.getValue() + ", going to " + entry.getKey().getName());
        }
    }
}