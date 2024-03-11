import java.util.HashMap;
import java.util.Map;

public class Church extends Attraction implements Visitable {
    private Map<String, String> visitingHours;

    public Church(String name, String description) {
        super(name, description);
        this.visitingHours = new HashMap<>();
    }
    @Override
    public void setVisitingHours(Map<String, String> visitingHours) {
        this.visitingHours = visitingHours;
    }
}
