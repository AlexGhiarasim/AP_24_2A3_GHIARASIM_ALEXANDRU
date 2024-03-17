import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();
    default LocalTime getOpeningHour(LocalDate date, Map<LocalDate, TimeInterval> timetable) {
        return timetable.get(date).getFirst();
    }
}
