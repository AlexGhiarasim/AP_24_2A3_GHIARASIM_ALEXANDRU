import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Museum extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;

    public Museum(String name, String description, Map<LocalDate, TimeInterval> timetable, double ticketPrice) {
        super(name, description);
        this.timetable = timetable;
        this.ticketPrice = ticketPrice;
    }
    public Museum(String name, String description) {
        super(name, description);
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }
}
