import java.time.LocalDate;
import java.time.LocalTime;

public class Church extends Attractions implements Visitable {
    private String name;

    public Church(String name) {
        this.name = name;
    }

    @Override
    public void setVisitingHours(LocalDate date, LocalTime start, LocalTime end) {
        super.setVisitingHours(date, start, end);
    }

    @Override
    public Attractions.TimeInterval<LocalTime> getVisitingHours(LocalDate date) {
        return super.getVisitingHours(date);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
