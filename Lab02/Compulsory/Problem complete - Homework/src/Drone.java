
public class Drone extends Vehicle {

    private int maximumFlightDuration;

    public Drone(String name, int maximumFlightDuration) {
        super(name);
        this.maximumFlightDuration = maximumFlightDuration;
    }

    public Drone(int maximumFlightDuration) {
        super();
        this.maximumFlightDuration = maximumFlightDuration;
    }

    public int getMaximumFlightDuration() {
        return maximumFlightDuration;
    }

    public void setMaximumFlightDuration(int maximumFlightDuration) {
        this.maximumFlightDuration = maximumFlightDuration;
    }
}

