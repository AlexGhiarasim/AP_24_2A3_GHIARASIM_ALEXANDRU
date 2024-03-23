import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Driver implements Person{
    private final String name;
    @Getter
    private int age;
    private final Destination destination;
    @Getter
    private Passenger passenger;

    public Driver(String name, Destination destination, int age) {
        this.name = name;
        this.age = age;
        this.destination = destination;
    }

    public void setPassenger(Passenger passenger)
    {
        if(passenger.getDestination().equals(destination))
        {
            this.passenger = passenger;
            //System.out.println("Assign successfully");
        }
        else
        {
            this.passenger = null;
            //System.out.println("Assign unsuccessfully");
        }
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public Destination getDestination() {
        return this.destination;
    }
    @Override
    public String toString() {
        return name;
    }

}
