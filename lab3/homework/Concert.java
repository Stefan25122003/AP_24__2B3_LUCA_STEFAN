import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Attractions implements Payable, Visitable {
    private String name;
    private double price;

    public Concert(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
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