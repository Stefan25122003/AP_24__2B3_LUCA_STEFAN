import java.time.LocalTime;

public class Statue extends Attractions implements Visitable{
    private String name;
    private LocalTime start;
    private LocalTime stop;
    public Statue(String name,LocalTime start, LocalTime stop){
        this.name = name;
        this.start = start;
        this.stop = stop;
    }


    @Override
    public void setVisitingHours(LocalTime start, LocalTime stop) {
        this.start = start;
        this.stop = stop;
    }
    @Override
    public String getName(){
        return this.name;
    }
}