import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;
import java.time.LocalTime;
public class Trip extends Attractions implements Visitable {
    private String cityName;
    private List<Attractions> attractions;

    public Trip(String cityName, List<Attractions> attractions) {
        this.cityName = cityName;
        this.attractions = new ArrayList<>(attractions);
    }

    public void addAttraction(Attractions attraction) {
        attractions.add(attraction);
    }

    public List<Visitable> getVisitableNotPayableLocations() {
        List<Visitable> visitableNotPayableLocations = new ArrayList<>();
        for (Attractions attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableNotPayableLocations.add((Visitable) attraction);
            }
        }
        Collections.sort(visitableNotPayableLocations, Comparator.comparing(v -> v.getOpeningHour(LocalDate.now())));
        return visitableNotPayableLocations;
    }

    @Override
    public String getName() {
        return this.cityName;
    }

    @Override
    public void setVisitingHours(LocalDate date, LocalTime start, LocalTime end) {
        super.setVisitingHours(date, start, end);
    }

    @Override
    public String toString() {
        String atrattionsNames = new String();
        int counter = 0;
        int iterator = 0;
        for (Attractions attraction : attractions) {
            counter++;
        }
        for (Attractions attraction : attractions) {
            atrattionsNames += attraction.getName();
            iterator++;
            if (iterator != counter)
                atrattionsNames += ", ";
            else
                atrattionsNames += " ";


        }

        return "The trip will take place in " + cityName + ", and the attractions are: " + atrattionsNames + '.';
    }
}


