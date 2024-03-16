import java.time.LocalTime;

public class Concert extends Attractions implements Payable{
    private String name;
    private double price;
    private LocalTime start;
    private LocalTime stop;
    public Concert(String name, double price, LocalTime start, LocalTime stop){
        this.name = name;
        this.price = price;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void setVisitingHours(LocalTime start, LocalTime stop) {
        this.start = start;
        this.stop = stop;
    }
    @Override
    public double getPrice(){
        return price;
    }
    @Override
    public String getName(){
        return this.name;
    }
}