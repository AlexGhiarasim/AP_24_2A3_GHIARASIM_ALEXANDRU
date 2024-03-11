import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {
    private Map<String, String> visitingHours;

    public Map<String, String> getVisitingHours() {
        return visitingHours;
    }

    public double getEntryFee() {
        return entryFee;
    }

    private double entryFee;

    public Concert(String name, String description) {
        super(name, description);
        this.visitingHours = new HashMap<>();
    }

    @Override
    public void setVisitingHours(Map<String, String> visitingHours) {
        this.visitingHours = visitingHours;
    }

    @Override
    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

}