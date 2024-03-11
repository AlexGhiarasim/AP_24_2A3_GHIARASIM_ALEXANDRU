import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Statue statue = new Statue("A", "cel mai frumos");
        Church church = new Church("B", "cel mai elegant");
        Concert concert = new Concert("C", "o amintire de neuitat");

        Map<String, String> churchVisitingHours = new HashMap<>();
        churchVisitingHours.put("Luni", "9:00-18:00");
        churchVisitingHours.put("Duminica", "inchis");
        church.setVisitingHours(churchVisitingHours);

        concert.setEntryFee(50.0);

        Trip trip = new Trip("Iasi", LocalTime.of(10,0), LocalTime.of(20,0));
        trip.addAttraction(statue);
        trip.addAttraction(church);
        trip.addAttraction(concert);

        System.out.println(trip);
    }
}
