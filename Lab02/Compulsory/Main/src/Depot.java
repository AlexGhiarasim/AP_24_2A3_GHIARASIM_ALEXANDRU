package Main.src;

import java.util.Arrays;

public class Depot {
    private String name;
    private Vehicle[] vehicles;

    public void setName(String name) {
        this.name = name;
    }

    public Depot(String name, Vehicle[] vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + Arrays.toString(vehicles) +
                '}';
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }
}
