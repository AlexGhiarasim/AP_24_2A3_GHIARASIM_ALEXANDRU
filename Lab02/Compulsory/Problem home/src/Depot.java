import java.util.Arrays;
import java.util.Objects;

public class Depot {
    private String name;
    private Vehicle[] vehicles;
    public Depot(String name) {
        this.name = name;
    }
    public Depot(String name, Vehicle[] vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setVehicles(Vehicle ... vehicles) {
        this.vehicles = vehicles;
        for(Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Depot{" +
                "name='" + name + '\'' +
                ", vehicles=[");

        for (int i = 0; i < vehicles.length; i++) {
            sb.append(vehicles[i].getName());
            if (i < vehicles.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]}");
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name);
    }
}
