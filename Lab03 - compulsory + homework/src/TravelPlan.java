import java.util.HashMap;
import java.util.Map;

public class TravelPlan {
    private Map<Attraction, Integer> timePlanToVisit = new HashMap<>();
    private Map<Attraction, Integer> durationOfVisit = new HashMap<>();

    public TravelPlan() {}

    public Map<Attraction, Integer> getTimePlanToVisit() {
        return timePlanToVisit;
    }

    public void setTimePlanToVisit(Map<Attraction, Integer> timePlanToVisit) {
        this.timePlanToVisit = timePlanToVisit;
    }

    public Map<Attraction, Integer> getDurationOfVisit() {
        return durationOfVisit;
    }

    public void setDurationOfVisit(Map<Attraction, Integer> durationOfVisit) {
        this.durationOfVisit = durationOfVisit;
    }

    public void addAPlanToVisit(Attraction attraction, Integer day, Integer duration) {
        timePlanToVisit.put(attraction, day);
        durationOfVisit.put(attraction, duration);
    }

    public void printTravelPlan() { // it iterates through the list of all attraction, and it will print the values sorted by day
        // sorting by day refers to specify for all the attractions in which day will be visited
        System.out.println("Plan to visit for these days: ");
        for (int day = 1; day <= 3; day++) {
            System.out.println("~~Day " + day + "~~");
            for (Map.Entry<Attraction, Integer> entry : timePlanToVisit.entrySet()) {
                Attraction attraction = entry.getKey();
                Integer time = entry.getValue();
                Integer duration = durationOfVisit.get(attraction);
                if (time == day) {
                    System.out.println("I will visit " + attraction.name + " for " + duration + " hours");
                }
            }
        }
    }
}
