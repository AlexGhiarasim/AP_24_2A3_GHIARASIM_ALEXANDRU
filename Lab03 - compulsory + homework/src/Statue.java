import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Statue extends Attraction implements Visitable{
    Map<LocalDate, TimeInterval> timetable;
    public Statue(String name, String description) {
        super(name, description);
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }

}