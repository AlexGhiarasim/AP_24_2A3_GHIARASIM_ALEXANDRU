import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Here I created objects of each class using specific constructor
        // For all classes I have ore or more constructors depending on
        // the number of parameters I want to inject into the constructor

        Statue statue1 = new Statue("Statuia lui Stefan", "O adevarata capodopera");
        Church church1 = new Church("Statuia lui Mircea cel Batran", "Ceva iesit din comun");
        Church church2 = new Church("Biserica Sfantul Ioan", "O frumoasa biserica veche");
        Concert concert = new Concert("Concertul lui Dorian Popa", "O experienta pentru tinerii pasionati de acest gen de muzica");
        Museum museum1 = new Museum("Muzeul de istorie Carol I", "Unul din cele mai vestite din Romania");

        TimeInterval museumTimetable1 = new TimeInterval(LocalTime.of(9, 0), LocalTime.of(18, 0));
        TimeInterval museumTimetable2 = new TimeInterval(LocalTime.of(10, 0), LocalTime.of(17, 0));
        TimeInterval museumTimetable3 = new TimeInterval(LocalTime.of(11, 0), LocalTime.of(19, 30));

        Map<LocalDate, TimeInterval> museum1TimetableMap = new HashMap<>();
        museum1TimetableMap.put(LocalDate.of(2024, 3, 16), museumTimetable1);
        museum1TimetableMap.put(LocalDate.of(2024, 3, 17), museumTimetable2);
        museum1TimetableMap.put(LocalDate.of(2024, 3, 18), museumTimetable3);
        museum1.setTimetable(museum1TimetableMap); // set for timetable
        museum1.setTicketPrice(20); //// is payable, so it must set a ticket price if you didn't inject in constructor


        TimeInterval concertTimetable1 = new TimeInterval(LocalTime.of(20, 0), LocalTime.of(22, 0));
        TimeInterval concertTimetable2 = new TimeInterval(LocalTime.of(21, 0), LocalTime.of(23, 0));
        TimeInterval concertTimetable3 = new TimeInterval(LocalTime.of(19, 0), LocalTime.of(21, 0));

        Map<LocalDate, TimeInterval> concertTimetableMap = new HashMap<>();
        concertTimetableMap.put(LocalDate.of(2024, 3, 16), concertTimetable1);
        concertTimetableMap.put(LocalDate.of(2024, 3, 17), concertTimetable2);
        concertTimetableMap.put(LocalDate.of(2024, 3, 18), concertTimetable3);
        concert.setTimetable(concertTimetableMap);
        church1.setTimetable(concertTimetableMap); // here I used the same program as concert!!
        church2.setTimetable(concertTimetableMap); // here I used the same program as concert!!
        statue1.setTimetable(concertTimetableMap); // here I used the same program as concert!!

        concert.setTicketPrice(50.0);

        Trip trip = new Trip("Iasi", LocalDate.of(2024, 3, 16), LocalDate.of(2024, 3, 18));
        trip.addAttraction(statue1);
        trip.addAttraction(church1);
        trip.addAttraction(church2);
        trip.addAttraction(museum1);
        trip.addAttraction(concert);
        System.out.println(trip + "\n"); // printing the trip plan

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addAPlanToVisit(statue1, 1, 2); // this means that the tourist visits statue1 in 1st day and he will
        travelPlan.addAPlanToVisit(church1, 2, 1); // stay 2 hours. For the others it works similarly.
        travelPlan.addAPlanToVisit(church2, 3, 1);
        travelPlan.addAPlanToVisit(museum1, 1, 3);
        travelPlan.addAPlanToVisit(concert, 2, 2);
        travelPlan.addAPlanToVisit(concert, 3, 2);
        travelPlan.printTravelPlan(); // this function print the plan for a tourist for which attractions will he visit in the established schedule
        System.out.println("\n Here is visitable locations:");

        trip.displayLocationsVisitable();
    }
}
