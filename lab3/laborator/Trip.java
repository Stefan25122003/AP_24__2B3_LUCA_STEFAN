import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
public class Trip extends Attractions implements Visitable{
    private String cityName;
    private LocalTime start;
    private LocalTime stop;
    private List<Attractions> attractions;

    public Trip(String cityName, LocalTime start, LocalTime stop, Attractions... attractions){
        this.cityName = cityName;
        this.start = start;
        this.stop = stop;
        this.attractions = new ArrayList<>();
        for (Attractions attraction : attractions)
        {
            this.attractions.add(attraction);
        }
    }

    public void addAttraction(Attractions attraction)
    {
        attractions.add(attraction);
    }
    @Override
    public void setVisitingHours(LocalTime start, LocalTime stop) {
        this.start = start;
        this.stop = stop;
    }
    @Override
    public String getName(){
        return this.cityName;
    }

    @Override
    public String toString()
    {
        String atrattionsNames = new String();
        int counter = 0;
        int iterator = 0;
        for(Attractions attraction: attractions){
            counter++;
        }
        for(Attractions attraction: attractions){
            atrattionsNames += attraction.getName();
            iterator++;
            if(iterator != counter)
                atrattionsNames += ", ";
            else
                atrattionsNames += " ";


        }

        return "The trip will take place in " + cityName + ", starts at  " + start + " and ends at  " + stop + " and the attractions are: " + atrattionsNames +'.';
    }
}