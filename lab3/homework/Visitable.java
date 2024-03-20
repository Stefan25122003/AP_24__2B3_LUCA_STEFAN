import java.time.LocalDate;
import java.time.LocalTime;

public interface Visitable {
    void setVisitingHours(LocalDate date, LocalTime start, LocalTime end);

    default LocalTime getOpeningHour(LocalDate date) {
        return null;
    }

    default Attractions.TimeInterval<LocalTime> getVisitingHours(LocalDate date) {
        return null;
    }
}
