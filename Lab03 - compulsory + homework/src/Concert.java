import java.time.LocalDate;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> timetable;

    private double ticketPrice;
    public Concert(String name, String description, Map<LocalDate, TimeInterval> timetable, double ticketPrice) {
        super(name, description);
        this.timetable = timetable;
        this.ticketPrice = ticketPrice;
    }
    public Concert(String name, String description) {
        super(name, description);
    }
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