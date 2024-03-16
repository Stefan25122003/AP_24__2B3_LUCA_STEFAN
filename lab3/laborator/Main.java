import java.time.LocalTime;
public class Main {
    public static void main(String[] args){
        Church biserica = new Church("Catedrala Mantuirii neamului",LocalTime.of(2,7),LocalTime.of(4,21));
        biserica.setVisitingHours(LocalTime.of(1,4),LocalTime.of(1,4));

        Concert concert = new Concert("Untold",29.99,LocalTime.of(3,20),LocalTime.of(4,20));
        double pretBiletConcert = concert.getPrice();

        Statue statuie = new Statue("Hidra",LocalTime.of(6,10),LocalTime.of(7,19));
        statuie.setVisitingHours(LocalTime.of(3,10),LocalTime.of(5,2));
        String numeStatue = statuie.getName();

        Trip excursie = new Trip("Romania",LocalTime.of(8,0),LocalTime.of(18,0),biserica,statuie);
        excursie.addAttraction(concert);

        System.out.println(excursie);
    }
}