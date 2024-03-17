import java.time.LocalDate;
import java.util.*;

public class Trip {
    private String city;
    private LocalDate start, end;
    private Map<LocalDate, ArrayList<TimeInterval>> visitingTimetable = new HashMap<>();
    private ArrayList<Attraction> attractions = new ArrayList<>();

    public Trip(String city, LocalDate start, LocalDate end) {
        this.city = city;
        this.start = start;
        this.end = end;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setVisitingTimetable(Map<LocalDate, ArrayList<TimeInterval>> visitingTimetable) {
        this.visitingTimetable = visitingTimetable;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void setVisitingTimetable(LocalDate date, ArrayList<TimeInterval> timeIntervals) {
        visitingTimetable.put(date, timeIntervals);
    }
    public void displayLocationsVisitable() {
        //here is a list to put the visitable locations, and not payable
        List<Attraction> sortedVisitableLocations = new ArrayList<>();
        // The algorithm will iterate through all the attractions, and it will find the ones that are churches or statues
        for (Attraction attraction : this.attractions) {
            if (attraction instanceof Church || attraction instanceof Statue) {
                sortedVisitableLocations.add(attraction);
            }
        }

        // sorting the list using a specific comparator, depending on their opening hour
        Arrays.sort(sortedVisitableLocations.toArray(new Attraction[0]), (p1, p2) -> { // comparator
            switch (p1) {
                // both are churches
                case Church church1 when p2 instanceof Church -> {
                    Church church2 = (Church) p2;
                    return church1.getOpeningHour(LocalDate.of(2024, 3, 16), church1.getTimetable())
                            .compareTo(church2.getOpeningHour(LocalDate.of(2024, 3, 16), church2.getTimetable()));
                }

                // both are statues
                case Statue statue1 when p2 instanceof Statue statue2 -> {
                    return statue1.getOpeningHour(LocalDate.of(2024, 3, 16), statue1.getTimetable())
                            .compareTo(statue2.getOpeningHour(LocalDate.of(2024, 3, 16), statue2.getTimetable()));
                }

                // the first is church and the second is statue
                case Church church when p2 instanceof Statue -> {
                    Statue statue = (Statue) p2;
                    return church.getOpeningHour(LocalDate.of(2024, 3, 16), church.getTimetable())
                            .compareTo(statue.getOpeningHour(LocalDate.of(2024, 3, 16), statue.getTimetable()));
                }

                // the first is statue and the second is church
                case Statue statue when p2 instanceof Church -> {
                    Church church = (Church) p2;
                    return statue.getOpeningHour(LocalDate.of(2024, 3, 16), statue.getTimetable())
                            .compareTo(church.getOpeningHour(LocalDate.of(2024, 3, 16), church.getTimetable()));
                }
                // a default case
                case null, default -> {
                    return 0;
                }
            }
        });
        // printing the values
        for (Attraction attraction : sortedVisitableLocations) {
            System.out.println(attraction.name);
        }
    }

    public Map<LocalDate, ArrayList<TimeInterval>> getVisitingTimetable() {
        return visitingTimetable;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "city='" + city + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", attractions=" + attractions +
                '}';
    }
}
