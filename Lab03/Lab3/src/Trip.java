import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trip {
    private String cityName;
    private LocalTime start;

    @Override
    public String toString() {
        return "Trip{" +
                "cityName='" + cityName + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", attractions=" + attractions +
                '}';
    }

    private LocalTime end;

    private List<Attraction> attractions = new ArrayList<>();

    public Trip(String cityName, LocalTime start, LocalTime end) {
        this.cityName = cityName;
        this.start = start;
        this.end = end;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
    public List<Attraction> getAttractions() {
        return attractions;
    }
    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

}