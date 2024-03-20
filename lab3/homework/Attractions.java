import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Attractions {

    static class TimeInterval<T> {
        private T start;
        private T end;

        public TimeInterval(T start, T end) {
            this.start = start;
            this.end = end;
        }

        public T getStart() {
            return start;
        }

        public T getEnd() {
            return end;
        }
    }


    private Map<LocalDate, TimeInterval<LocalTime>> visitingTimetable;

    public Attractions() {
        visitingTimetable = new HashMap<>();
    }

    public void setVisitingHours(LocalDate date, LocalTime start, LocalTime end) {
        visitingTimetable.put(date, new TimeInterval<>(start, end));
    }

    public TimeInterval<LocalTime> getVisitingHours(LocalDate date) {
        return visitingTimetable.get(date);
    }

    public String getName() {
        return null;
    }
}