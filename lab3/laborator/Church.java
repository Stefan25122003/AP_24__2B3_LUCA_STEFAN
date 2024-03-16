import java.time.LocalTime;
public class  Church extends Attractions implements Visitable {
    private String name;
    private LocalTime start;
    private LocalTime stop;
    public Church(String name, LocalTime start, LocalTime stop){
        this.start=start;
        this.stop=stop;

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
